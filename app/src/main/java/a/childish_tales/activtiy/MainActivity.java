package a.childish_tales.activtiy;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import a.childish_tales.Database.DatabaseStory;
import a.childish_tales.Database.Query;
import a.childish_tales.R;
import a.childish_tales.recyclerview.main.AdapterMain;
import a.childish_tales.recyclerview.main.ItemMain;
import a.childish_tales.recyclerview.slider.ItemSlider;

public class MainActivity extends AppCompatActivity {
    private String TAG = "amnigoli-MainActivity.class";

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
        add();
        layoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    void add(){
        String   id = null
                ,title = null
                ,desc = null
                ,text = null
                ,image = null
                ,time = null
                ,writer = null
                ,narrator = null
                ,file_sound = null
                ,my_sound = null
                ,memory = null;
        int file_sound2 = 0,
                image2 = 0,
                displayed= 0,
                favorite = 0;
        ArrayList<ItemSlider> itemTwos = new ArrayList<>();

        SQLiteDatabase databaseStory = new DatabaseStory(getApplication()).getReadableDatabase();
        Cursor rawQuery = Query.select_all_table_list(databaseStory);
        while (rawQuery.moveToNext()){
            id = rawQuery.getString(rawQuery.getColumnIndex("id")) ;
            title = rawQuery.getString(rawQuery.getColumnIndex("title")) ;
            desc = rawQuery.getString(rawQuery.getColumnIndex("desc")) ;
            text = rawQuery.getString(rawQuery.getColumnIndex("text")) ;
            image = rawQuery.getString(rawQuery.getColumnIndex("image")) ;
            time = rawQuery.getString(rawQuery.getColumnIndex("time")) ;
            writer = rawQuery.getString(rawQuery.getColumnIndex("writer")) ;
            narrator = rawQuery.getString(rawQuery.getColumnIndex("narrator")) ;
            file_sound = rawQuery.getString(rawQuery.getColumnIndex("file_sound")) ;
            my_sound = rawQuery.getString(rawQuery.getColumnIndex("my_sound")) ;
            memory = rawQuery.getString(rawQuery.getColumnIndex("memory")) ;
            displayed = rawQuery.getInt(rawQuery.getColumnIndex("displayed")) ;
            favorite = rawQuery.getInt(rawQuery.getColumnIndex("favorite")) ;

            if (file_sound.startsWith("R") && image.startsWith("R")){
                image2 = R.drawable.s_1;
                file_sound2 = R.raw.s_1;
            }
            itemTwos.add(new ItemSlider(
                    id,
                    title,
                    desc,
                    text,
                    file_sound,
                    null,
                    image,
                    time,
                    writer,narrator,
                    my_sound, memory,
                    0,
                    image2,
                    displayed,
                    favorite));
            itemTwos.add(new ItemSlider(
                    id,
                    title,
                    desc,
                    text,
                    file_sound,
                    null,
                    image,
                    time,
                    writer,narrator,
                    my_sound, memory,
                    0,
                    image2,
                    displayed,
                    favorite));
            itemTwos.add(new ItemSlider(
                    id,
                    title,
                    desc,
                    text,
                    file_sound,
                    null,
                    image,
                    time,
                    writer,narrator,
                    my_sound, memory,
                    0,
                    image2,
                    displayed,
                    favorite));
        }
        databaseStory.close();
        rawQuery.close();

        itemIntroList.add(new ItemMain("قصه های آموزنده",itemTwos));
    }
}