package a.childish_tales;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoStoryActivity extends AppCompatActivity {
    ImageView bg_image;
    TextView title,desc,writer_narrator,time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_story);
        bg_image = findViewById(R.id.background_image);
        title = findViewById(R.id.title);
        desc = findViewById(R.id.desc);
        writer_narrator = findViewById(R.id.writer_narrator);
        time = findViewById(R.id.time);


        bg_image.setImageResource(getIntent().getIntExtra("image",R.drawable.s_1));
        title.setText(getIntent().getStringExtra("title"));
        desc.setText(getIntent().getStringExtra("desc"));
        writer_narrator.setText(getIntent().getStringExtra("writer"));
        writer_narrator.append(", "+getIntent().getStringExtra("narrator"));
        time.setText(getIntent().getStringExtra("time"));
    }

    public void back(View view) {
        finish();
    }
}
