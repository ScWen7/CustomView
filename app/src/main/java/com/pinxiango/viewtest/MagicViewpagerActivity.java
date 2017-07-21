package com.pinxiango.viewtest;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MagicViewpagerActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private int [] imageIds  = {R.drawable.temple01,R.drawable.temple02,R.drawable.temple03,R.drawable.zhanweitu};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_viewpager);
        viewpager = (ViewPager)findViewById(R.id.viewpager);
        viewpager.setAdapter(new MyAdapter());
        viewpager.setPageMargin(20);
        viewpager.setOffscreenPageLimit(3);
        viewpager.setCurrentItem(1);
        viewpager.setPageTransformer(false,new AlphaPageTranformer());
    }
    class  MyAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return imageIds.length;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(MagicViewpagerActivity.this);
            imageView.setBackgroundResource(imageIds[position]);
            container.addView(imageView);
            return  imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
