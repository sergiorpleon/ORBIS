package com.uclv.dte;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Zoom extends AppCompatActivity {

  private TouchImageView image;
  //private DecimalFormat df;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_zoom);

    //df = new DecimalFormat("#.##");
    image = (TouchImageView) findViewById(R.id.idzoomimg);
  }
}