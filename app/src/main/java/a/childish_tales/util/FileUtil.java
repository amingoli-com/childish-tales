package a.childish_tales.util;

import android.content.Context;

import androidx.annotation.Nullable;

import java.io.File;
import java.util.Objects;

import a.childish_tales.data.Constans;

public class FileUtil {
    @Nullable
    public static String getBaseDirectory(Context context) {
        return Objects.requireNonNull(context.getExternalFilesDir(null)).getAbsolutePath()+"/";
    }

    public static File getFileImageStory(Context context,String FileName){
        return new File(getBaseDirectory(context)+ Constans.folder_image+"/"+FileName);
    }
    public static File getFileAudioStory(Context context,String FileName){
        return new File(getBaseDirectory(context)+ Constans.folder_audio +"/"+FileName);
    }
}
