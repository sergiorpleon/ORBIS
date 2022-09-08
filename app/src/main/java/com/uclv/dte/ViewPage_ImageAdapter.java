package com.uclv.dte;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

/**
 * Created by SERGIO-PC on 22/02/2019.
 */

public class ViewPage_ImageAdapter extends PagerAdapter{
  private Context context;

  public String[] images = new String[] {
          "sitio/assets/images/1.jpg",
          "sitio/assets/images/2.jpg",
          "sitio/assets/images/3.jpg",
          "sitio/assets/images/4.jpg",
          "sitio/assets/images/5.jpg",
          "sitio/assets/images/6.jpg",
          "sitio/assets/images/7.jpg",
          "sitio/assets/images/8.jpg",
          "sitio/assets/images/9.jpg",
          "sitio/assets/images/10.jpg",
          "sitio/assets/images/11.jpg",
          "sitio/assets/images/12.jpg",
          "sitio/assets/images/13.jpg",
          "sitio/assets/images/14.jpg",
          "sitio/assets/images/15.jpg",
          "sitio/assets/images/16.jpg",
          "sitio/assets/images/17.jpg",
          "sitio/assets/images/18.jpg",
          "sitio/assets/images/19.jpg",
          "sitio/assets/images/20.jpg",
          "sitio/assets/images/21.jpg",
          "sitio/assets/images/22.jpg",
          "sitio/assets/images/23.jpg",
          "sitio/assets/images/24.jpg",
          "sitio/assets/images/25.jpg",
          "sitio/assets/images/26.jpg",
          "sitio/assets/images/27.jpg",
          "sitio/assets/images/28.jpg",
          "sitio/assets/images/29.jpg",
          "sitio/assets/images/30.jpg",
          "sitio/assets/images/31.jpg",
          "sitio/assets/images/32.jpg",
          "sitio/assets/images/33.jpg",
          "sitio/assets/images/34.jpg",
          "sitio/assets/images/35.jpg",
          "sitio/assets/images/36.jpg",
          "sitio/assets/images/37.jpg",
          "sitio/assets/images/38.jpg",
          "sitio/assets/images/39.jpg",
          "sitio/assets/images/40.jpg",
          "sitio/assets/images/41.jpg",
          "sitio/assets/images/42.jpg",
          "sitio/assets/images/43.jpg",
          "sitio/assets/images/44.jpg",
          "sitio/assets/images/45.jpg",
          "sitio/assets/images/46.jpg",
          "sitio/assets/images/47.jpg",
          "sitio/assets/images/48.jpg",
          "sitio/assets/images/49.jpg",
          "sitio/assets/images/50.jpg",
          "sitio/assets/images/51.jpg",
          "sitio/assets/images/52.jpg",
          "sitio/assets/images/53.jpg",
          "sitio/assets/images/54.jpg",
          "sitio/assets/images/55.jpg",
          "sitio/assets/images/56.jpg",
          "sitio/assets/images/57.jpg",
          "sitio/assets/images/58.jpg",
          "sitio/assets/images/59.jpg",
          "sitio/assets/images/60.jpg",
          "sitio/assets/images/61.jpg",
          "sitio/assets/images/62.jpg",
          "sitio/assets/images/63.jpg",
          "sitio/assets/images/64.jpg",
          "sitio/assets/images/65.jpg",
          "sitio/assets/images/66.jpg"};

  public String[] titles;

  public ViewPage_ImageAdapter(Context paramContext) {
    this.context = paramContext;
    this.titles = new String[] {
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS",
            "ORBIS"};
  }

  @Override
  public int getCount() {
    return images.length;
  }

  @Override
  public boolean isViewFromObject(View view, Object object) {
    return view == ((View) object);
  }

  @Override
  public Object instantiateItem(ViewGroup container, int position) {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View item = inflater.inflate(R.layout.activity_zoom, container, false);

    //---Accedo al campo title
    //TextView lbltitle = (TextView) item.findViewById(R.id.idtitle);
    //lbltitle.setText(titles[position]);

    //---Accedo al campo imagen
    TouchImageView imgview = (TouchImageView)item.findViewById(R.id.idzoomimg);
    //TouchImageView imgview = new TouchImageView(context);
    imgview.setImageResource(R.drawable.ic_launcher);
    InputStream in;
    try {
      String imagen = images[position]; //obtencion del nombre de la imagen
      //imagen = imagen.toLowerCase();
      in = context.getAssets().open(imagen); //obtencion de fichero input de la imagen a partir de su nombre
      Bitmap bitmap = BitmapFactory.decodeStream(in);
      imgview.setImageBitmap(bitmap);
    } catch (Exception e) {
      e.printStackTrace();
    }

    container.addView(item);
    return item;
  }

  @Override
  public void destroyItem(ViewGroup container, int position, Object object){
    ((ViewPager)container).removeView((View)object);
  }

}