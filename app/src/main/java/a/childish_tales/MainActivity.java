package a.childish_tales;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.dingmouren.layoutmanagergroup.slide.ItemConfig;
import com.dingmouren.layoutmanagergroup.slide.ItemTouchHelperCallback;
import com.dingmouren.layoutmanagergroup.slide.OnSlideListener;
import com.dingmouren.layoutmanagergroup.slide.SlideLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String TAG = "amnigoli-MainActivity.class";

    List<Item> itemIntroList;
    RecyclerView mRecyclerView;
    AdapterTest mAdapter;

    ItemTouchHelperCallback mItemTouchHelperCallback;
    ItemTouchHelper mItemTouchHelper;
    SlideLayoutManager mSlideLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemIntroList = new ArrayList<>();
        mRecyclerView = findViewById(R.id.recycler_view);
        mAdapter = new AdapterTest(this,itemIntroList);
        mRecyclerView.setAdapter(mAdapter);

        add();

        mItemTouchHelperCallback = new ItemTouchHelperCallback(mRecyclerView.getAdapter(), itemIntroList);
        mItemTouchHelper = new ItemTouchHelper(mItemTouchHelperCallback);
        mSlideLayoutManager = new SlideLayoutManager(mRecyclerView, mItemTouchHelper);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
        mRecyclerView.setLayoutManager(mSlideLayoutManager);

        mItemTouchHelperCallback.setOnSlideListener(new OnSlideListener() {

            @Override
            public void onSliding(RecyclerView.ViewHolder viewHolder, float ratio, int direction) {
                if (direction == ItemConfig.SLIDING_LEFT) {
                    Log.e(TAG, "onSliding-SLIDED_LEFT");
                } else if (direction == ItemConfig.SLIDING_RIGHT) {
                    Log.e(TAG, "onSliding-SLIDING_RIGHT");
                }
            }

            @Override
            public void onSlided(RecyclerView.ViewHolder viewHolder, Object o, int direction) {
                if (direction == ItemConfig.SLIDED_LEFT) {
                    Log.e(TAG, "SLIDED_LEFT");
                } else if (direction == ItemConfig.SLIDED_RIGHT) {
                    Log.e(TAG, "SLIDED_RIGHT");
                }
                int position = viewHolder.getAdapterPosition();
                Log.e(TAG, "onSlided--position:" + position);
            }

            @Override
            public void onClear() {
                add();
                mAdapter.notifyDataSetChanged();
                mRecyclerView.getAdapter();
            }
        });
    }

    void add(){
        itemIntroList.add(new Item(R.drawable.logo));
        itemIntroList.add(new Item(R.drawable.logo));
        itemIntroList.add(new Item(R.drawable.logo));
        itemIntroList.add(new Item(R.drawable.logo));
    }
}
