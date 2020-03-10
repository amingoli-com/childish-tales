package a.childish_tales.util.file;

import android.content.Context;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import a.childish_tales.R;

public class UnzipFirstFile {
  private String TAG = "amingoli-zip";
  private Context context;

  public UnzipFirstFile(Context context) {
    this.context = context;
    if (!FileUtil.getFileImageStory(context,"s_2.png").exists()){
      unzip();
    }
  }
  private void unzip(){
    try {
      BufferedOutputStream dest = null;
      ZipInputStream zis = new ZipInputStream(context.getResources().openRawResource(R.raw.archive));
      ZipEntry entry;
      while ((entry = zis.getNextEntry()) != null) {
        File file = new File(FileUtil.getBaseDirectory(context) + entry.getName());
        if (file.exists()) {
          continue;
        }
        if (entry.isDirectory()) {
          if (!file.exists())
            file.mkdirs();
          continue;
        }
        int count;
        byte data[] = new byte[2048];
        FileOutputStream fos = new FileOutputStream(file);
        dest = new BufferedOutputStream(fos, 2048);
        while ((count = zis.read(data, 0, 2048)) != -1) {
          Log.d(TAG, "unzip: "+count);
          dest.write(data, 0, count);
        }
        dest.flush();
        dest.close();
      }
      zis.close();
      Log.d(TAG, "unzip: finish");
    } catch (Exception e) {
      e.printStackTrace();
      Log.e(TAG, "unzip: ",e);
    }
  }



}
