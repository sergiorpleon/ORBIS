package com.uclv.dte;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.webkit.JavascriptInterface;

public class Intermediario {
    MainActivity mContext;

    Intermediario(MainActivity c){
        mContext = c;
    }

    @JavascriptInterface
    public void showPage(String page){
        sendMessage("page",page);
    }

    @JavascriptInterface
    public void showPdf(String page){
        sendMessage("pdf",page);
    }

    @JavascriptInterface
    public void showVideo(String page){
        sendMessage("video",page);
    }


    @JavascriptInterface
    public void showofGaleria(String paramString) {
        sendMessage("galeria", paramString);
    }

    public void sendMessage(String type, String value){
        Intent intent = new Intent("my-event");
        intent.putExtra("type",type);
        intent.putExtra("message",value);

        LocalBroadcastManager.getInstance(mContext).sendBroadcast(intent);
    }
}
