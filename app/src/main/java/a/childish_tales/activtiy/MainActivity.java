package a.childish_tales.activtiy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemIntroList = new ArrayList<>();
        mRecyclerView = findViewById(R.id.recycler_view);
        mAdapter = new AdapterMain(this,itemIntroList);
        mRecyclerView.setAdapter(mAdapter);
        addItemFromJson();
        layoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
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
}