package a.childish_tales.activtiy;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import a.childish_tales.R;
import a.childish_tales.recyclerview.multi.MultiAdaptor;
import a.childish_tales.recyclerview.multi.MultiItem;
import a.childish_tales.util.file.FileUtil;

public class MainActivity extends AppCompatActivity {
    private String TAG = "amnigoli-MainActivity";

    ArrayList<MultiItem> itemIntroList;
    RecyclerView mRecyclerView;
    MultiAdaptor mAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onStart() {
        super.onStart();
        onWindowFocusChanged(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemIntroList = new ArrayList<>();
        mRecyclerView = findViewById(R.id.recycler_view);
        mAdapter = new MultiAdaptor(itemIntroList,this);
        mRecyclerView.setAdapter(mAdapter);
//        addItemFromJson2();

        itemIntroList.add(new MultiItem(MultiItem.TITLE,"This is Test",true));

        layoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    void addItemFromJson(){
        ArrayList<MultiItem> itemTwos = new ArrayList<>();
        try {
            JSONArray jsonArray =
                    new JSONArray(FileUtil.readAssets(this,"list_story.json"));
            for (int i = 0; i <jsonArray.length() ; i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                String id = object.getString("id");
                String title = object.getString("title");
                String desc = object.getString("desc");
                String text = object.getString("text");
                String image_url = object.getString("image_url");
                String time = object.getString("time");
                String recorder = object.getString("recorder");
                String sound_name = object.getString("sound_name");
                String sound_url = object.getString("sound_url");
                    itemTwos.add(new MultiItem(MultiItem.SLIDER_LAKCHERI,title,desc,image_url,sound_name,sound_url));
            }
            itemIntroList.add(new MultiItem(itemTwos));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    void addItemFromJson2(){
        try {
            JSONObject jsonObject =
                    new JSONObject(FileUtil.readAssets(this,"list_story.json"));
            Iterator iterator = jsonObject.keys();
            while(iterator.hasNext()){
                ArrayList<MultiItem> itemTwos = new ArrayList<>();
                String key = (String)iterator.next();
                JSONObject issue = jsonObject.getJSONObject(key);
                //  get id from  issue
                String name = issue.optString("name");
                JSONArray array = issue.getJSONArray("array");

                String sound_url = null;
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    String title = object.getString("title");
                    String desc = object.getString("desc");
                    String image_url = object.getString("image_url");
                    String sound_name = object.getString("sound_name");
                    if (!object.isNull("sound_url"))
                        sound_url = object.getString("sound_url");
                    itemTwos.add(new MultiItem(MultiItem.SLIDER_LAKCHERI,title,desc,image_url,sound_name,sound_url));
                }
                itemIntroList.add(new MultiItem(itemTwos));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}