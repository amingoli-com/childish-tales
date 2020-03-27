package a.childish_tales.activtiy;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import a.childish_tales.R;
import a.childish_tales.api.Api;
import a.childish_tales.api.ApiListener;
import a.childish_tales.manager.SaveManager;
import a.childish_tales.recyclerview.multi.MultiAdaptor;
import a.childish_tales.recyclerview.multi.MultiItem;
import a.childish_tales.util.file.FileUtil;

public class ListViewActivity extends AppCompatActivity {
    private String TAG = "amnigoli-MainActivity";

    ArrayList<MultiItem> itemIntroList;
    RecyclerView mRecyclerView;
    MultiAdaptor mAdapter;
    RecyclerView.LayoutManager layoutManager;
    ProgressBar progressBar;
    Button btn_try_again;
    String url = null;

    @Override
    protected void onStart() {
        super.onStart();
        onWindowFocusChanged(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        url = getIntent().getStringExtra("url");

        mRecyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progress);
        btn_try_again = findViewById(R.id.btn_try_again);

        itemIntroList = new ArrayList<>();
        mAdapter = new MultiAdaptor(itemIntroList,this);
        mRecyclerView.setAdapter(mAdapter);
        setItem();
    }

    void setItem(){
        progressBar.setVisibility(View.GONE);
        btn_try_again.setVisibility(View.GONE);
        if (url==null){
            JSON_SETER(FileUtil.readAssets(this,"list_story.json"));
        }else {
            progressBar.setVisibility(View.VISIBLE);
            JSON_SETER_ONLINE();
        }
    }

    void JSON_SETER(String JSON){
        try {
            JSONArray jsonArray = new JSONArray(JSON);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                String json = String.valueOf(object);
                String type = object.getString("type");
                switch (type){
                    case "TEXT_BOX":
                        TEXT_BOX(json);
                        break;
                    case "IMAGE":
                        IMAGE(json);
                        break;
                    case "TITLE":
                        TITLE(json);
                        break;
                    case "SLIDER_L":
                    case "SLIDER_H":
                    case "SLIDER_V":
                        SLIDER_L_H_V(json,type);
                        break;
                    default:
                        break;
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, "JSON_SETER_OFFLINE: "+e);
        }
        layoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
    }
    void JSON_SETER(){
        JSON_SETER(getJsonMain());
    }

    void JSON_SETER_ONLINE(){
        Api.GET(url, new ApiListener() {
            @Override
            public void onResult(String result) {
                JSON_SETER(result);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFiled() {
                btn_try_again.setVisibility(View.VISIBLE);
            }
        });
    }

    void TEXT_BOX(String json) throws JSONException {
        MultiItem items = new MultiItem();
        JSONObject object = new JSONObject(json);
        items.setType(MultiItem.TEXT_BOX);
        if (!object.isNull("text"))
            items.setText(object.getString("text"));
        if (!object.isNull("on_click"))
            items.setOn_click(object.getString("on_click"));
        else items.setOn_click("null");
        if (!object.isNull("url"))
            items.setUrl(object.getString("url"));
        try {
            JSONObject story = object.getJSONObject("story");
            if (!story.isNull("title"))
                items.setStory_title(story.getString("title"));
            if (!story.isNull("desc"))
                items.setStory_desc(story.getString("desc"));
            if (!story.isNull("image"))
                items.setStory_image(story.getString("image"));
            if (!story.isNull("sound_name"))
                items.setStory_soundName(story.getString("sound_name"));
            if (!story.isNull("sound"))
                items.setStory_sound(story.getString("sound"));
        }catch (Exception e){
            e.printStackTrace();
        }
        itemIntroList.add(items);
    }

    void IMAGE(String json) throws JSONException {
        String image = "";
        MultiItem items = new MultiItem();
        JSONObject object = new JSONObject(json);
        items.setType(MultiItem.IMAGE);
        if (!object.isNull("image"))
            image = object.getString("image");
        items.setImage(image);
        if (!object.isNull("title"))
            items.setTitle(object.getString("title"));
        if (!object.isNull("on_click"))
            items.setOn_click(object.getString("on_click"));
        else items.setOn_click("null");
        if (!object.isNull("url"))
            items.setUrl(object.getString("url"));
        try {
            JSONObject story = object.getJSONObject("story");
            if (!story.isNull("title"))
                items.setStory_title(story.getString("title"));
            if (!story.isNull("desc"))
                items.setStory_desc(story.getString("desc"));
            if (!story.isNull("image"))
                items.setStory_image(story.getString("image"));
            if (!story.isNull("sound_name"))
                items.setStory_soundName(story.getString("sound_name"));
            if (!story.isNull("sound"))
                items.setStory_sound(story.getString("sound"));
        }catch (Exception e){
            e.printStackTrace();
        }
        itemIntroList.add(items);
    }

    void TITLE(String json) throws JSONException {
        MultiItem items = new MultiItem();
        JSONObject object = new JSONObject(json);
        items.setType(MultiItem.TITLE);
        if (!object.isNull("title"))
            items.setTitle(object.getString("title"));
        if (!object.isNull("on_click")) {
            items.setBoolean(true);
            items.setOn_click(object.getString("on_click"));
        }
        else {
            items.setOn_click("null");
            items.setBoolean(false);
        }
        if (!object.isNull("url"))
            items.setUrl(object.getString("url"));
        try {
            JSONObject story = object.getJSONObject("story");
            if (!story.isNull("title"))
                items.setStory_title(story.getString("title"));
            if (!story.isNull("desc"))
                items.setStory_desc(story.getString("desc"));
            if (!story.isNull("image"))
                items.setStory_image(story.getString("image"));
            if (!story.isNull("sound_name"))
                items.setStory_soundName(story.getString("sound_name"));
            if (!story.isNull("sound"))
                items.setStory_sound(story.getString("sound"));
        }catch (Exception e){
            e.printStackTrace();
        }
        itemIntroList.add(items);
    }

    void SLIDER_L_H_V(String json, String type) throws JSONException {
        MultiItem multiItem = new MultiItem();
        ArrayList<MultiItem> multiItemArrayList = new ArrayList<>();
        switch (type){
            case "SLIDER_L":
                multiItem.setType(MultiItem.SLIDER_LAKCHERI);
                break;
            case "SLIDER_H":
                multiItem.setType(MultiItem.SLIDER_HORIZONTAL);
                break;
            default:
                multiItem.setType(MultiItem.SLIDER_VERTICAL);
                break;
        }

        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("list");
        for (int i = 0; i < jsonArray.length(); i++) {
            MultiItem item_story = new MultiItem();

            JSONObject json_object_story = jsonArray.getJSONObject(i);
            if (!json_object_story.isNull("on_click"))
                item_story.setOn_click(json_object_story.getString("on_click"));
            else item_story.setOn_click("null");
            if (!json_object_story.isNull("url"))
                item_story.setUrl(json_object_story.getString("url"));
            try {
                JSONObject object_story = json_object_story.getJSONObject("story");
                if (!object_story.isNull("title"))
                    item_story.setStory_title(object_story.getString("title"));
                if (!object_story.isNull("desc"))
                    item_story.setStory_desc(object_story.getString("desc"));
                if (!object_story.isNull("image"))
                    item_story.setStory_image(object_story.getString("image"));
                if (!object_story.isNull("sound_name"))
                    item_story.setStory_soundName(object_story.getString("sound_name"));
                if (!object_story.isNull("sound"))
                    item_story.setStory_sound(object_story.getString("sound"));
            }catch (Exception e){
                e.printStackTrace();
            }
            multiItemArrayList.add(item_story);
        }
        multiItem.setArrayList(multiItemArrayList);
        itemIntroList.add(multiItem);
    }

    String getJsonMain(){
        return SaveManager.get(this).getstring_appINFO().get(SaveManager.jsonMain);
    }



    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    public void intent(View view) {
        switch (view.getTag().toString()){
            case "tryAgain":
                setItem();
                break;
        }
    }
}