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
import java.util.Objects;

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

//        addItemFromJson();
        String image = "https://github.com/amingoli78/childish-tales/raw/master/image/creation.png";
        String title = "حضرت مهدی (عج)";


        itemIntroList.add(TEXT_BOX(title));
        itemIntroList.add(IMAGE(image,title));
        itemIntroList.add(IMAGE(image));
        itemIntroList.add(TITLE(title,true));
        itemIntroList.add(TITLE(title));
        aVoid();

        layoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    MultiItem TEXT_BOX(String text){
        MultiItem item = new MultiItem();
        item.setType(MultiItem.TEXT_BOX);
        item.setText(text);
        return item;
    }

    MultiItem IMAGE(String image,String title){
        MultiItem item = new MultiItem();
        item.setType(MultiItem.IMAGE);
        item.setImage(image);
        item.setText(title);
        return item;
    }
    MultiItem IMAGE(String image){
        MultiItem item = new MultiItem();
        item.setType(MultiItem.IMAGE);
        item.setImage(image);
        item.setTitle(null);
        return item;
    }

    MultiItem TITLE(String title, Boolean showFlesh){
        MultiItem item = new MultiItem();
        item.setType(MultiItem.TITLE);
        item.setTitle(title);
        item.setBoolean(showFlesh);
        return item;
    }
    MultiItem TITLE(String title){
        MultiItem item = new MultiItem();
        item.setType(MultiItem.TITLE);
        item.setTitle(title);
        item.setBoolean(false);
        return item;
    }

    MultiItem SLIDER_LAKCHERI(ArrayList<MultiItem> arrayList){
        MultiItem item = new MultiItem();
        item.setType(MultiItem.SLIDER_LAKCHERI);
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


    void aVoid(){
        try {
            JSONObject jsonObject = new JSONObject(Objects.requireNonNull
                    (FileUtil.readAssets(this, "list_story.json")));
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
                itemIntroList.add(SLIDER_LAKCHERI(itemTwos));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
/*
    void addItemFromJson(){
        String image = "https://github.com/amingoli78/childish-tales/raw/master/image/creation.png";
        String titl = "حضرت مهدی (عج)";
        String des = "امام صادق علیه\u200Cالسلام فرمود: چون بلا بر بلا فزاید، (نشانۀ) رهایى از بلا باشد.\n" +
                "\n";

        ArrayList<MultiItem> itemTwo_h = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            itemTwo_h.add(new MultiItem(MultiItem.SLIDER_HORIZONTAL,image,titl+"-"+i));
        }
        itemIntroList.add(new MultiItem(MultiItem.SLIDER_HORIZONTAL,itemTwo_h));



        ArrayList<MultiItem> itemTwo_v = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            itemTwo_v.add(new MultiItem(MultiItem.SLIDER_VERTICAL,image,titl+"-"+i,des));
        }
        itemIntroList.add(new MultiItem(MultiItem.SLIDER_VERTICAL,itemTwo_v));




        itemIntroList.add(new MultiItem(MultiItem.TEXT_BOX,des));
        itemIntroList.add(new MultiItem(MultiItem.TWO_ICON,image,titl,image,titl));
        itemIntroList.add(new MultiItem(MultiItem.IMAGE,image,titl));
        itemIntroList.add(new MultiItem(MultiItem.SLIDER_VERTICAL,image,titl,des));
        itemIntroList.add(new MultiItem(MultiItem.TITLE,titl,true));




        try {
            JSONObject jsonObject = new JSONObject(Objects.requireNonNull
                    (FileUtil.readAssets(this, "list_story.json")));
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
                itemIntroList.add(new MultiItem(MultiItem.getSliderLakcheri(),itemTwos));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
*/
}