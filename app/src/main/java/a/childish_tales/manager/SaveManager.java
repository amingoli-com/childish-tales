package a.childish_tales.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

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
    public static final String apiV6_URL = "apiV6_URL";

    public void change_apiV6_URL(String local_URL) {
        editor.putString(apiV6_URL, local_URL);
        editor.apply();
    }
    public Map<String, String> getstring_appINFO() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(apiV6_URL, sharedPreferences.getString(apiV6_URL, "https://khadije.com/api/v6" ));
        return hashMap;
    }



}