package a.childish_tales.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.File;

public class ViewUtil {
    public static void setImageResource(Context context, ImageView imageView, String FileName){
        File imgFile = FileUtil.getFileImageStory(context,FileName);
        if(imgFile.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            imageView.setImageBitmap(myBitmap);
        }
    }
}
