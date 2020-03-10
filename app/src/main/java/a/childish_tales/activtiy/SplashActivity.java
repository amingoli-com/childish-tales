package a.childish_tales.activtiy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;

import com.downloader.Error;
import com.downloader.OnCancelListener;
import com.downloader.OnDownloadListener;
import com.downloader.OnPauseListener;
import com.downloader.OnProgressListener;
import com.downloader.OnStartOrResumeListener;
import com.downloader.PRDownloader;
import com.downloader.PRDownloaderConfig;
import com.downloader.Progress;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import a.childish_tales.R;
import a.childish_tales.util.file.FileUtil;
import a.childish_tales.util.file.UnzipFirstFile;

public class SplashActivity extends AppCompatActivity {
    private String TAG = "amingoli-splash";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        PRDownloader.initialize(getApplicationContext());

// Enabling database for resume support even after the application is killed:
        PRDownloaderConfig config = PRDownloaderConfig.newBuilder()
                .setDatabaseEnabled(true)
                .build();
        PRDownloader.initialize(getApplicationContext(), config);

// Setting timeout globally for the download network requests:
        PRDownloaderConfig config2 = PRDownloaderConfig.newBuilder()
                .setReadTimeout(30_000)
                .setConnectTimeout(30_000)
                .build();
        PRDownloader.initialize(getApplicationContext(), config2);




        int downloadId =
                PRDownloader.download(
                        "https://khadije.com/static/images/homepage-v3/salavat.jpg",
                        FileUtil.getBaseDirectory(this),
                        "test.jpg")
                .build()
                .setOnStartOrResumeListener(() -> {
                    Log.d(TAG, "setOnStartOrResumeListener: ");
                })
                .setOnPauseListener(() -> {
                    Log.d(TAG, "setOnPauseListener: ");
                })
                .setOnCancelListener(() -> {
                    Log.d(TAG, "setOnCancelListener: ");
                })
                .setOnProgressListener(progress -> {
                    Log.d(TAG, "setOnProgressListener: "+progress);
                })
                .start(new OnDownloadListener() {
                    @Override
                    public void onDownloadComplete() {
                        Log.d(TAG, "onDownloadComplete: ");
                    }

                    @Override
                    public void onError(Error error) {
                        Log.d(TAG, "onError: "+error);
                    }
                });



//        new UnzipFirstFile(this);

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
