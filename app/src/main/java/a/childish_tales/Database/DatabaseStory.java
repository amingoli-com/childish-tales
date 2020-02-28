package a.childish_tales.Database;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseStory extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "story.db";

    public static String table_list = "list";
    public static String list_id = "id";
    public static String list_title = "title";
    public static String list_desc = "desc";
    public static String list_text = "text";
    public static String list_image = "image";
    public static String list_time = "time";
    public static String list_writer = "writer";
    public static String list_narrator = "narrator";
    public static String list_file_sound = "file_sound";
    public static String list_my_sound = "my_sound";
    public static String list_memory = "memory";
    public static String list_displayed = "displayed";
    public static String list_favorite = "favorite";

    public static final int DATABASE_VERSION = 1;

    public DatabaseStory(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        setForcedUpgrade();
    }





}