package a.childish_tales;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

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
        ArrayList<ItemSlider> itemTwos = new ArrayList<>();
        itemTwos.add(new ItemSlider(
                "1",
                "موش زیرک",
                "داستان کودکانه «موش زیرک» تقدیم به بچه های خوب «در یکی از روزهای قشنگ پاییزی موش کوچولو در دل جنگل سبز قدم می زد که روباهی یک دفعه او را دید و دهانش آب افتاد: کجا میروی موش کوچولو؟ به کلبه ی زیر زمینی من بیا و...",
                null,
                null,
                "https://niniban.com/files/fa/news/1398/12/6/396225_362.mp3",
                R.drawable.s_1,
                "داستان ۵ دقیقه زمان میبره",
                "فاطمه فرهاد","زهرا خدایار",
                "", "",
                3,
                false,false));
        itemTwos.add(new ItemSlider(
                "1",
                "موش زیرک",
                "داستان کودکانه «موش زیرک» تقدیم به بچه های خوب «در یکی از روزهای قشنگ پاییزی موش کوچولو در دل جنگل سبز قدم می زد که روباهی یک دفعه او را دید و دهانش آب افتاد: کجا میروی موش کوچولو؟ به کلبه ی زیر زمینی من بیا و...",
                null,
                null,
                "https://niniban.com/files/fa/news/1398/12/6/396225_362.mp3",
                R.drawable.s_2,
                "داستان ۱۰ دقیقه زمان میبره",
                "فاطمه فرهاد","زهرا خدایار",
                "", "",
                3,
                false,false));
        itemTwos.add(new ItemSlider(
                "1",
                "موش زیرک",
                "داستان کودکانه «موش زیرک» تقدیم به بچه های خوب «در یکی از روزهای قشنگ پاییزی موش کوچولو در دل جنگل سبز قدم می زد که روباهی یک دفعه او را دید و دهانش آب افتاد: کجا میروی موش کوچولو؟ به کلبه ی زیر زمینی من بیا و...",
                null,
                null,
                "https://niniban.com/files/fa/news/1398/12/6/396225_362.mp3",
                R.drawable.s_3,
                "داستان ۱۰ دقیقه زمان میبره",
                "فاطمه فرهاد","زهرا خدایار",
                "", "",
                3,
                false,false));


        itemIntroList.add(new ItemMain("قصه های آموزنده",itemTwos));
        itemIntroList.add(new ItemMain("قصه های قرآنی",itemTwos));
    }
}
