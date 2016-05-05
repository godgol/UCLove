package com.example.christophe.uclove;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class GalleryActivity extends Activity {
    Integer[] pics = {
            R.drawable.firendpic,R.drawable.rose
    };
    ImageView profilePic;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_gallery);

        Gallery gallery = (Gallery)findViewById(R.id.gallery);
        gallery.setAdapter(new ImageAdapter(this));

        profilePic = (ImageView)findViewById(R.id.ImageView01);
        gallery.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getBaseContext(),"Define as profile picture",Toast.LENGTH_SHORT).show();
                imageView.setImageResource(pics[arg2]);
            }
        });

    }


    public class ImageAdapter extends BaseAdapter {

        private Context ctx;
        int imageBackground;

        public ImageAdapter(Context c) {
            ctx = c;
            TypedArray ta = obtainStyledAttributes(R.styleable.Gallery1);
            imageBackground = ta.getResourceId(R.styleable.Gallery1_android_galleryItemBackground, 1);
            ta.recycle();
        }

        @Override
        public int getCount() {
            return pics.length;
        }

        @Override
        public Object getItem(int arg0) {
            return arg0;
        }

        @Override
        public long getItemId(int arg0) {
            return arg0;
        }
        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {
            ImageView iv = new ImageView(ctx);
            iv.setImageResource(pics[arg0]);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setLayoutParams(new Gallery.LayoutParams(150,120));
            iv.setBackgroundResource(imageBackground);
            return iv;
        }
    }
}