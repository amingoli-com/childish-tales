package a.childish_tales.activtiy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.ContextWrapper;
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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import a.childish_tales.Database.DatabaseStory;
import a.childish_tales.Database.Query;
import a.childish_tales.R;
import a.childish_tales.util.UnzipFirstFile;
import ir.mahdi.mzip.zip.ZipArchive;

public class SplashActivity extends AppCompatActivity {
    private String TAG = "amingoli-splash";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        File directory = contextWrapper.getDir(getFilesDir().getName(), Context.MODE_PRIVATE);
        String basePath = directory.getAbsolutePath();
        new UnzipFirstFile(this);

//        String root = Environment.getExternalStorageDirectory().toString();
        String root = getExternalFilesDir(null).getAbsolutePath();

/*        File imgFile = new  File("/sdcard/Images/test_image.jpg");

        if(imgFile.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            ImageView myImage = (ImageView) findViewById(R.id.image);
            myImage.setImageBitmap(myBitmap);

        }*/



        Log.d(TAG, "onCreate: "+root);

        new Handler().postDelayed(() -> startActivity(new Intent(SplashActivity.this, MainActivity.class)),3000);
    }


    private void SaveImage(Bitmap finalBitmap) {

        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/saved_images");
        if (!myDir.exists()) {
            myDir.mkdirs();
        }
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Image-"+ n +".jpg";
        File file = new File (myDir, fname);
        if (file.exists ())
            file.delete ();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeFileExternalStorage() {
        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        File directory = contextWrapper.getDir(getFilesDir().getName(), Context.MODE_PRIVATE);
        File file =  new File(directory,"fileName");
        String data = "TEST DATA";
        FileOutputStream fos = null; // save
        try {
            fos = new FileOutputStream("fileName", true);
            fos.write(data.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
