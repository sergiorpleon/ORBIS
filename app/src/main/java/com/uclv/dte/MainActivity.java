package com.uclv.dte;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView myBrowser;
    String actual = "file:///android_asset/sitio/index.html";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myBrowser = (WebView) findViewById(R.id.webview);

        WebSettings settings = myBrowser.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);

        myBrowser.loadUrl("file:///android_asset/sitio/index.html");
        myBrowser.addJavascriptInterface(new Intermediario(this),"Android");

        int nightModeFlags = getApplicationContext().getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                /* si esta activo el modo oscuro lo desactiva */
                AppCompatDelegate.setDefaultNightMode(
                        AppCompatDelegate.MODE_NIGHT_NO);
                break;
        }
    }

    @Override
    public void onBackPressed() {
            if( actual.equalsIgnoreCase("file:///android_asset/sitio/index.html")){
                super.onBackPressed();
            }else{
                myBrowser.loadUrl("file:///android_asset/sitio/index.html");
                actual = "file:///android_asset/sitio/index.html";
            }
            actual = "file:///android_asset/sitio/index.html";
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, new IntentFilter("my-event"));
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
        super.onPause();
    }

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String type = intent.getStringExtra("type");
            String message = intent.getStringExtra("message");

            switch (type){
                case "page":
                    myBrowser.loadUrl("file:///android_asset/sitio/"+message+".html");
                    actual = "file:///android_asset/sitio/"+message+".html";
                    break;
                case "pdf":
                    //Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                    //myBrowser.loadUrl("file:///android_asset/web/preview/"+message+".html");
                    Intent pdf = new Intent(context, PDFActivity.class);
                    pdf.putExtra("pdf",message);
                    startActivity(pdf);
                    break;
                case "video":
                    Intent video = new Intent(context, VideoActivity.class);
                    startActivity(video);
                    break;
                case "galeria":
                    intent = new Intent(context, ViewPage_activity.class);
                    intent.putExtra("id", Integer.parseInt(message));
                    MainActivity.this.startActivity(intent);
            }
        }
    };
}