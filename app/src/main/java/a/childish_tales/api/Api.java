package a.childish_tales.api;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import a.childish_tales.manager.ApplicationManager;

public class Api {
    public static void GET(String url, ApiListener listener){
        StringRequest request = new StringRequest
                (Request.Method.GET, url, listener::onResult, e -> listener.onFiled());
        request.setRetryPolicy(new DefaultRetryPolicy(
                DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        ApplicationManager.getInstance().addToRequestQueue(request);
    }
}
