package a.childish_tales.activtiy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;
import a.childish_tales.R;
import a.childish_tales.api.Api;
import a.childish_tales.api.ApiListener;
import a.childish_tales.data.Constans;
import a.childish_tales.manager.SaveManager;
import a.childish_tales.util.file.FileUtil;

public class SplashActivity extends AppCompatActivity {
    private String TAG = "amingoli-splash";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Api.GET(Constans.url_splash, new ApiListener() {
            @Override
            public void onResult(String result) {
                try {
                    Log.d(TAG, "get URL List Json");
                    JSONObject jsonObject = new JSONObject(result);
                    String url = jsonObject.getString("main_json");
                    Api.GET(url, new ApiListener() {
                        @Override
                        public void onResult(String result) {
                            Log.d(TAG, "Get List Json");
                            setJsonMain(result);
                        }
                        @Override
                        public void onFiled() {
                            noConnection();
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                    noConnection();
                }
            }
            @Override
            public void onFiled() {
                noConnection();
            }
        });
    }

    void setJsonMain(String json){
        Log.d(TAG, "setJsonMain: ");
        Log.e("json", "splashActivity.class\njson main is: "+json );
        SaveManager.get(this).saveJsonMain(json);
        nextActivity();
    }
    String getJsonMain(){
        return SaveManager.get(this).getstring_appINFO().get(SaveManager.jsonMain);
    }
    void noConnection(){
        Log.d(TAG, "noConnection");
        if (getJsonMain()==null){
            setJsonMain(FileUtil.readAssets(this, "list_story.json"));
        }
        nextActivity();
    }
    void nextActivity(){
        new Handler().postDelayed(() -> {
                    startActivity(new Intent(SplashActivity.this, ListViewActivity.class));
                    finish();
                    }
                ,500);
    }

}
