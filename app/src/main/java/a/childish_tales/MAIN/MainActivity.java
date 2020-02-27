package a.childish_tales.MAIN;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.dingmouren.layoutmanagergroup.skidright.SkidRightLayoutManager;
import java.util.ArrayList;
import java.util.List;

import a.childish_tales.R;
import a.childish_tales.TWO.ItemTwo;

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
        ArrayList<ItemTwo> itemTwos = new ArrayList<>();
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemTwos.add(new ItemTwo(R.drawable.s_1));
        itemTwos.add(new ItemTwo(R.drawable.logo));
        itemIntroList.add(new ItemMain("قصه\u200Cهای آموزنده",itemTwos));
        itemIntroList.add(new ItemMain("قصه های قرآنی",itemTwos));
    }
}
