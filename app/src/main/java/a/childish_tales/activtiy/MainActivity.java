package a.childish_tales.activtiy;

import android.os.Bundle;
import android.util.Log;
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
import a.childish_tales.manager.SaveManager;
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

//        addItemFromJson();
        String image = "https://github.com/amingoli78/childish-tales/raw/master/image/creation.png";
        String title = "حضرت مهدی (عج)";

        JSON_SETER();

        /*itemIntroList.add(IMAGE(image,title));
        itemIntroList.add(IMAGE(image));
        itemIntroList.add(TITLE(title));
        additem_lakcheri();
        itemIntroList.add(TITLE(title));
        additem_h();
        itemIntroList.add(TITLE(title));
        additem_v();*/

        layoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    MultiItem SET_ITEM_SLIDER_LAKCHERI(ArrayList<MultiItem> arrayList){
        MultiItem item = new MultiItem();
        item.setType(MultiItem.SLIDER_LAKCHERI);
        item.setArrayList(arrayList);
        return item;
    }

    MultiItem SLIDER_HORIZONTAL(ArrayList<MultiItem> arrayList){
        MultiItem item = new MultiItem();
        item.setType(MultiItem.SLIDER_HORIZONTAL);
        item.setArrayList(arrayList);
        return item;
    }

    MultiItem SLIDER_VERTICAL(ArrayList<MultiItem> arrayList){
        MultiItem item = new MultiItem();
        item.setType(MultiItem.SLIDER_VERTICAL);
        item.setArrayList(arrayList);
        return item;
    }

    MultiItem ADD_STORY_ITEM(String title,String desc,String image,String soundName,String sound){
        MultiItem item = new MultiItem();
        item.setStory_title(title);
        item.setStory_desc(desc);
        item.setStory_image(image);
        item.setStory_soundName(soundName);
        item.setStory_sound(sound);
        return item;
    }


    void additem_lakcheri(){
        try {
            JSONObject jsonObject = new JSONObject(getJsonMain());
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
                    itemTwos.add(ADD_STORY_ITEM(title,desc,image_url,sound_name,sound_url));
                }
//                itemIntroList.add(SLIDER_L_H_V(itemTwos));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    void additem_h(){
        try {
            JSONObject jsonObject = new JSONObject(getJsonMain());
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
                    itemTwos.add(ADD_STORY_ITEM(title,desc,image_url,sound_name,sound_url));
                }
                itemIntroList.add(SLIDER_HORIZONTAL(itemTwos));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    void additem_v(){
        try {
            JSONObject jsonObject = new JSONObject(getJsonMain());
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
                    itemTwos.add(ADD_STORY_ITEM(title,desc,image_url,sound_name,sound_url));
                }
                itemIntroList.add(SLIDER_VERTICAL(itemTwos));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    void JSON_SETER(){
        try {
            JSONArray jsonArray = new JSONArray(FileUtil.readAssets(this,"list_story.json"));
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
            Log.d(TAG, "JSON_SETER: "+e);
        }
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
}