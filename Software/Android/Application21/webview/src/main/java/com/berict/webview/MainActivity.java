package com.berict.webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        // use this to load local files
        webView.loadUrl("file:///android_asset/index.html");

        // show external websites in the app
        //webView.loadUrl("http://berict.com");
        webView.setWebViewClient(new CustomWebViewClient());
        webView.addJavascriptInterface(new JavascriptMethod(), "sample");

        findViewById(R.id.loadButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl(
                        ((EditText) findViewById(R.id.urlInput)).getText().toString()
                );
            }
        });
    }

    class JavascriptMethod {
        @android.webkit.JavascriptInterface
        public void showToast(String message) {
            Log.e("hmmmmm", "mmmmmmmmmmmmmmmmmmmmmmmmm");
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }

        @android.webkit.JavascriptInterface
        public void clickOnFace() {
            findViewById(R.id.loadButton).setVisibility(View.INVISIBLE);
        }
    }

    class CustomWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Toast.makeText(getApplicationContext(), view.getUrl(), Toast.LENGTH_SHORT).show();
            view.loadUrl(url);
            return true;
        }
    }
}
