package a.childish_tales;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.dingmouren.layoutmanagergroup.skidright.SkidRightLayoutManager;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String TAG = "amnigoli-MainActivity.class";

    List<Item> itemIntroList;
    RecyclerView mRecyclerView;
    AdapterTest mAdapter;

    SkidRightLayoutManager mSkidRightLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemIntroList = new ArrayList<>();
        mRecyclerView = findViewById(R.id.recycler_view);
        mAdapter = new AdapterTest(this,itemIntroList);
        mRecyclerView.setAdapter(mAdapter);

        add();

        mSkidRightLayoutManager = new SkidRightLayoutManager(1.80f, 0.5f);
        mRecyclerView.setLayoutManager(mSkidRightLayoutManager);
    }

    void add(){
        itemIntroList.add(new Item(R.drawable.logo));
        itemIntroList.add(new Item(R.drawable.logo));
        itemIntroList.add(new Item(R.drawable.logo));
        itemIntroList.add(new Item(R.drawable.logo));
    }
}
