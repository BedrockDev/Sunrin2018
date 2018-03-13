package com.berict.superrefresh;

import android.app.DownloadManager;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button btn;
    private ProgressBar progressBar;
    TextView txt;
    Integer count = 1;
    Integer repeatCount = 0;

    WebView myWebView;

    String url = "http://cafe.daum.net/udul.cafe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(100);
        btn = findViewById(R.id.btn);
        txt = findViewById(R.id.progress);
        myWebView = (WebView) findViewById(R.id.webview);

        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error){
                handler.proceed();
            }
        });

        myWebView.getSettings().setUserAgentString("Android WebView");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 1;
                progressBar.setProgress(0);
                repeatCount = Integer.parseInt(((EditText) findViewById(R.id.repeat)).getText().toString());
                //new RepeatingTask().execute(repeatCount);

                btn.setEnabled(false);
                progressBar.setMax(repeatCount);
                txt.setText("Connecting");
                for (int i = 0; i < repeatCount; i++) {
                    txt.setText(i + " / " + repeatCount);
                    progressBar.setProgress(i + 1);
                    myWebView.loadUrl(url);
                    Log.i("SR", "Loaded webview");
                }
                btn.setEnabled(true);
                txt.setText("Complete");
            }
        });
    }

    class RepeatingTask extends AsyncTask<Integer, Integer, String> {
        @Override
        protected String doInBackground(Integer... params) {
            for (count = 0; count <= repeatCount; count++) {
                try {
//                    URL obj = new URL(url);
//                    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//                    con.setRequestMethod("GET");
//                    con.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36");
//                    con.disconnect();
//                    onProgressUpdate(count);
//                    Log.i("SR", "Requested");
//
//                    BufferedReader in = new BufferedReader(
//                            new InputStreamReader(con.getInputStream()));
//                    String inputLine;
//                    StringBuffer response = new StringBuffer();
//
//                    while ((inputLine = in.readLine()) != null) {
//                        response.append(inputLine);
//                    }
//                    in.close();
//
//                    Log.i("SR", response.toString());
                    myWebView.loadUrl(url);
                } catch (Exception e) {
                    Log.e("SR", e.getMessage());
                }
            }
            return "Task Completed.";
        }

        @Override
        protected void onPostExecute(String result) {
            btn.setEnabled(true);
            txt.setText("Complete");
        }

        @Override
        protected void onPreExecute() {
            btn.setEnabled(false);
            progressBar.setMax(repeatCount);
            txt.setText("Connecting");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            txt.setText(count + " / " + repeatCount);
            progressBar.setProgress(values[0]);
        }
    }
}
