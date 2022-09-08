package com.uclv.dte;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ViewPage_activity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_page_activity);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);


    ViewPage_ImageAdapter adapter = new ViewPage_ImageAdapter(this);

    Intent i = getIntent();
    int pos = i.getExtras().getInt("id");

    ViewPager vpage = (ViewPager) findViewById(R.id.view_pager);
    vpage.setAdapter(adapter);
    vpage.setCurrentItem(pos);
  }

  @Override
  public boolean onSupportNavigateUp() {
    onBackPressed();
    return false;
  }
}