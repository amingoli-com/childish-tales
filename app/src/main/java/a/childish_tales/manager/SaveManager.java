package a.childish_tales.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

import a.childish_tales.util.file.FileUtil;

public class SaveManager extends ContextWrapper {

    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    public static final String SH_PREF_NAME = "ShPerfManager_Payamres";


    @SuppressLint("CommitPrefEdits")
    private SaveManager(Context context) {
        super(context);
        sharedPreferences = getSharedPreferences(SH_PREF_NAME, MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public static SaveManager get(Context context) {
        return new SaveManager(context);
    }


    /** App Info */
    public static final String jsonMain = "jsonMain";

    public void saveJsonMain(String json) {
        editor.putString(jsonMain, json);
        editor.apply();
    }
    public Map<String, String> getstring_appINFO() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(jsonMain, sharedPreferences.getString(jsonMain, FileUtil.readAssets(this, "list_story.json") ));
        return hashMap;
    }



}