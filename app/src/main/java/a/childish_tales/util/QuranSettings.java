package a.childish_tales.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;


public class QuranSettings {
  private static final String PREFS_FILE = "com.ermile.salamquran.android.per_installation";

  private static QuranSettings instance;

  private Context appContext;
  private SharedPreferences prefs;
  private SharedPreferences perInstallationPrefs;

  public static synchronized QuranSettings getInstance(@NonNull Context context) {
    if (instance == null) {
      instance = new QuranSettings(context.getApplicationContext());
    }
    return instance;
  }

  @VisibleForTesting
  public static void setInstance(QuranSettings settings) {
    instance = settings;
  }

  private QuranSettings(@NonNull Context appContext) {
    this.appContext = appContext;
    prefs = PreferenceManager.getDefaultSharedPreferences(appContext);
    perInstallationPrefs = appContext.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
  }




  public String getAppCustomLocation() {
    return perInstallationPrefs.getString("appLocation", getDefaultLocation());
  }

  public String getDefaultLocation() {
    return Environment.getExternalStorageDirectory().getAbsolutePath();
  }


}
