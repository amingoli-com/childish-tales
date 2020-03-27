package a.childish_tales.activtiy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;

import a.childish_tales.R;
import im.delight.android.webview.AdvancedWebView;

public class WebViewActivity extends AppCompatActivity implements AdvancedWebView.Listener, SwipeRefreshLayout.OnRefreshListener {
    String TAG = "amingoli78-WebViewActivity";
    SwipeRefreshLayout swipeRefreshLayout;
    AdvancedWebView mWebView;
    String url = null;

    @SuppressLint({"JavascriptInterface", "SetJavaScriptEnabled"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_web_view);

            url = getIntent().getStringExtra("url");

            swipeRefreshLayout = findViewById(R.id.swiperefreshlayout);
            mWebView = findViewById(R.id.webview);

            swipeRefreshLayout.setOnRefreshListener(this);
            swipeRefreshLayout.setRefreshing(true);

            mWebView.setScrollbarFadingEnabled(false);
            mWebView.setHorizontalScrollBarEnabled(false);
            mWebView.setVerticalScrollBarEnabled(false);
            mWebView.setScrollContainer(false);
            mWebView.getSettings().setDomStorageEnabled(true);
            mWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.getSettings().setLoadsImagesAutomatically(true);
            mWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            mWebView.getSettings().setSupportZoom(false);
            mWebView.getSettings().setSavePassword(false);
            mWebView.getSettings().setBlockNetworkImage(false);
            mWebView.getSettings().setSupportMultipleWindows(false);
            mWebView.getSettings().setAppCacheEnabled(true);
            mWebView.addJavascriptInterface(this, "jsinterface");
            mWebView.setOverScrollMode(View.OVER_SCROLL_NEVER);
            mWebView.setListener(this, this);
            mWebView.loadUrl(url);
        }catch (Exception e){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
            finish();
        }
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onPageStarted(String url, Bitmap favicon) {
        Log.d(TAG, "onPageStarted: ");
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void onPageFinished(String url) {
        Log.d(TAG, "onPageFinished: ");
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {
        Log.d(TAG, "onPageError: ");
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {

    }

    @Override
    public void onExternalPageRequest(String url) {

    }

    @Override
    public void onRefresh() {
        Log.d(TAG, "onRefresh: ");
        mWebView.loadUrl(url);
    }

    @Override
    public void onBackPressed() {
        if (!mWebView.onBackPressed()) { return; }
        super.onBackPressed();
    }
}
