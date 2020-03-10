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
import java.util.List;
import a.childish_tales.R;
import a.childish_tales.recyclerview.main.AdapterMain;
import a.childish_tales.recyclerview.main.ItemMain;
import a.childish_tales.recyclerview.slider.ItemSlider;
import a.childish_tales.util.file.FileUtil;

public class MainActivity extends AppCompatActivity {
    private String TAG = "amnigoli-MainActivity";

    List<ItemMain> itemIntroList;
    RecyclerView mRecyclerView;
    AdapterMain mAdapter;
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
        mAdapter = new AdapterMain(this,itemIntroList);
        mRecyclerView.setAdapter(mAdapter);
        addItemFromJson2();
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
        ArrayList<ItemSlider> itemTwos = new ArrayList<>();
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
                itemTwos.add(new ItemSlider(id, title, desc, text, image_url, time, recorder, sound_name, sound_url));
            }
            itemIntroList.add(new ItemMain("قصه های آموزنده",itemTwos));
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
                ArrayList<ItemSlider> itemTwos = new ArrayList<>();
                String key = (String)iterator.next();
                JSONObject issue = jsonObject.getJSONObject(key);
                //  get id from  issue
                String name = issue.optString("name");
                JSONArray array = issue.getJSONArray("array");

                String sound_url = null;
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    String id = object.getString("id");
                    String title = object.getString("title");
                    String desc = object.getString("desc");
                    String text = object.getString("text");
                    String image_url = object.getString("image_url");
                    String time = object.getString("time");
                    String recorder = object.getString("recorder");
                    String sound_name = object.getString("sound_name");
                    if (!object.isNull("sound_url"))
                        sound_url = object.getString("sound_url");
                    itemTwos.add(new ItemSlider(id, title, desc, text, image_url, time, recorder, sound_name, sound_url));
                }
                itemIntroList.add(new ItemMain(name,itemTwos));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}