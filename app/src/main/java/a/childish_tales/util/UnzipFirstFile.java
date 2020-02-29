package a.childish_tales.util;

import android.content.Context;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import a.childish_tales.R;

public class UnzipFirstFile {
  private Boolean isUnziping = false;
  private Context context;

  public UnzipFirstFile(Context context) {
    this.context = context;
    isUnziping = false;
    if (!isUnziping){
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
          Log.d("amingol", "extractZipfile: "+file.getAbsolutePath());
          continue;
        }
        if (entry.isDirectory()) {
          if (!file.exists())
            file.mkdirs();
          Log.d("amingol", "extractZipfile: Create directory: "+file.getAbsolutePath());
          continue;
        }
        Log.d("amingol", "extractZipfile: nExtracting: "+entry);
        int count;
        byte data[] = new byte[2048];
        Log.d("amingol", "extractZipfile: to: "+file.getAbsolutePath());
        FileOutputStream fos = new FileOutputStream(file);
        dest = new BufferedOutputStream(fos, 2048);
        while ((count = zis.read(data, 0, 2048)) != -1) {
          dest.write(data, 0, count);
        }
        dest.flush();
        dest.close();
      }
      zis.close();
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      Log.e("amingoli", "extractZipfile: ",e );
    }
  }



}
