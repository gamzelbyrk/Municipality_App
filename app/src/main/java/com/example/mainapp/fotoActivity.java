package com.example.mainapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class fotoActivity extends AppCompatActivity {
    private ViewPager2 viewpager2;
    private Handler sliderhandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);
        viewpager2 = findViewById(R.id.viewpagerimageslider);

        List<slideritem> slideritems= new ArrayList<>();
        slideritems.add(new slideritem(R.drawable.img1));
        slideritems.add(new slideritem(R.drawable.img2));
        slideritems.add(new slideritem(R.drawable.img3));
        slideritems.add(new slideritem(R.drawable.img4));
        slideritems.add(new slideritem(R.drawable.img5));
        slideritems.add(new slideritem(R.drawable.img6));
        slideritems.add(new slideritem(R.drawable.img7));
        slideritems.add(new slideritem(R.drawable.img8));
        slideritems.add(new slideritem(R.drawable.img9));
        slideritems.add(new slideritem(R.drawable.img10));

        viewpager2.setAdapter(new slideradapter(slideritems, viewpager2));

        viewpager2.setClipToPadding(false);
        viewpager2.setClipChildren(false);
        viewpager2.setOffscreenPageLimit(10);
        viewpager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer CompositePageTransformer = new CompositePageTransformer();
        CompositePageTransformer.addTransformer(new MarginPageTransformer(90));
        CompositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull  View page, float position) {
                float r = 1 - Math.abs(position);

                //page.getScaleY(0.85f + r + 0.15);


            }
        });

        viewpager2.setPageTransformer(CompositePageTransformer);

        viewpager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderhandler.removeCallbacks(sliderrunnable);
                sliderhandler.postDelayed(sliderrunnable,3000);

            }
        });

    }

    private Runnable sliderrunnable = new Runnable() {
        @Override
        public void run() {
            viewpager2.setCurrentItem(viewpager2.getCurrentItem() + 1);

        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        sliderhandler.removeCallbacks(sliderrunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sliderhandler.postDelayed(sliderrunnable, 3000);
    }
}