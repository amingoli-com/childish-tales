package a.childish_tales.api;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import org.json.JSONException;
import org.json.JSONObject;
import a.childish_tales.manager.ApplicationManager;

public class Api {
    public static void GET(String url, ApiListener listener){
        StringRequest sendDelRQ = new StringRequest(Request.Method.GET, url, response ->
        {
            try {
                JSONObject mainObject = new JSONObject(response);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, Throwable::printStackTrace);
        sendDelRQ.setRetryPolicy(new DefaultRetryPolicy(
                5 * 1000, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        ApplicationManager.getInstance().addToRequestQueue(sendDelRQ);
    }


    public static String GET_MAIN_URL(){
        GET("", new ApiListener() {
            @Override
            public String onResult(String result) {
                return result;
            }

            @Override
            public void onFiled() {
            }
        });
        return null;
    }
}
