package a.childish_tales;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class InfoStoryActivity extends AppCompatActivity {
    ImageView bg_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_story);
        bg_image = findViewById(R.id.background_image);

        bg_image.setImageResource(getIntent().getIntExtra("image",R.drawable.s_1));
    }

    public void back(View view) {
        finish();
    }
}
