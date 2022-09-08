package com.uclv.dte;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

import com.github.barteksc.pdfviewer.PDFView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView vvideo = (VideoView) findViewById(R.id.videoView);
        Uri path = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videoorbis);
        vvideo.setVideoURI(path);
        vvideo.setMediaController(new MediaController(this));
        vvideo.start();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // This is the up button
            case android.R.id.home:
                onBackPressed();
                // overridePendingTransition(R.animator.anim_left, R.animator.anim_right);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
 }