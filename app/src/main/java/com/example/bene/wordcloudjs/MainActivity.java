package com.example.bene.wordcloudjs;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import com.google.gson.Gson;



public class MainActivity extends AppCompatActivity {
    String cloudText;
    String maxWords;
    String rotateWords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Receive input from TextInputScreen
        Bundle cloudTextData = getIntent().getExtras();

        if (cloudTextData == null){
            return;
        }

        cloudText = cloudTextData.getString("CloudText");
        maxWords =  cloudTextData.getString("MaxWords");
        rotateWords = cloudTextData.getString("RotateWords");

        WebView webView = (WebView)findViewById(R.id.cloud);
        WebAppInterface webAppInterface = new WebAppInterface();

        webView.loadUrl("file:///android_asset/www/CloudView.html");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(webAppInterface, "JsData");
    }

    class WebAppInterface {
        //Make method available to JS in webview and create a json String with the received Input
        @android.webkit.JavascriptInterface
        public String loadData (){
            String [] jSData = {cloudText, maxWords, rotateWords};
            String json = new Gson().toJson(jSData);
            return json;
        }
    }


}
