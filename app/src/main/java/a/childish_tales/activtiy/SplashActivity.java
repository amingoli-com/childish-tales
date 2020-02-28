package a.childish_tales.activtiy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;

import a.childish_tales.Database.DatabaseStory;
import a.childish_tales.Database.Query;
import a.childish_tales.R;
import a.childish_tales.util.UnzipFirstFile;

public class SplashActivity extends AppCompatActivity {
    private String TAG = "amingoli-splash";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        File dir = Environment.getExternalStorageDirectory();
        String basePath = dir.getAbsolutePath();
        new UnzipFirstFile(this);

/*        File imgFile = new  File("/sdcard/Images/test_image.jpg");

        if(imgFile.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            ImageView myImage = (ImageView) findViewById(R.id.image);
            myImage.setImageBitmap(myBitmap);

        }*/


        Log.d(TAG, "onCreate: "+basePath);

        new Handler().postDelayed(() -> startActivity(new Intent(SplashActivity.this, MainActivity.class)),3000);
    }
}
