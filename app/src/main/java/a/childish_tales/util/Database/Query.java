package a.childish_tales.util.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Query {

    static String select(String table){
        return "SELECT * FROM "+table;
    }

    public static Cursor select_all_table_list(SQLiteDatabase database){
        return database.rawQuery("SELECT * FROM "+DatabaseStory.table_list,null);
    }

    public static boolean select_listStory(Context context,String ServerID){
        SQLiteDatabase database = new DatabaseStory(context).getReadableDatabase();
        Cursor rawQuery = database.rawQuery(
                select(DatabaseStory.table_list),null);
        while (rawQuery.moveToNext()){
            String id = rawQuery.getString(rawQuery.getColumnIndex("")) ;
            return false;
        }
        rawQuery.close();
        database.close();
        return true;
    }

    public static void insert_listStory (Context context, String toNumber, String text, String date, String smsID, String isSendToUser, String isSendToServer, String serverID){


/*        SQLiteDatabase smsDatabase = new DatabaseSMS(context).getWritableDatabase();
        String query = "INSERT INTO "
                + DatabaseSMS.table_SendSMS + "("
                + DatabaseSMS.sendSMS_toNumber +","
                + DatabaseSMS.sendSMS_text + ","
                + DatabaseSMS.sendSMS_date + ","
                + DatabaseSMS.sendSMS_smsID + ","
                + DatabaseSMS.sendSMS_isSendToUser + ","
                + DatabaseSMS.sendSMS_isSendToServer + ","
                + DatabaseSMS.getSMS_serverID + ")"
                + "Values ("
                + "'"+toNumber+"',"
                + " '"+text+"',"
                + " '"+date+"',"
                + " '"+smsID+"',"
                + " '"+isSendToUser+"',"
                + " '"+isSendToServer+"',"
                + " '"+serverID+"' )";
        Log.i(av.tag_SendSMS, "A 3- INSERT SMSNew To Table SendSMS \n Query: "+ query);

        smsDatabase.execSQL(query);
        smsDatabase.close();*/
    }
}
