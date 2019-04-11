package com.example.viewpagertest;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        viewPager.setAdapter(new PagerFragAdapter(getSupportFragmentManager(), strings));
        strings.add("6");
        viewPager.getAdapter().notifyDataSetChanged();
        // strings.clear();
        //viewPager.getAdapter().notifyDataSetChanged();
        strings.add("4");
        viewPager.getAdapter().notifyDataSetChanged();
        strings.add("5");
        viewPager.getAdapter().notifyDataSetChanged();
        //viewPager.setOffscreenPageLimit(1);

        viewPager.post(new Runnable() {
            @Override
            public void run() {
                PagerFragAdapter pagerFragAdapter = (PagerFragAdapter) viewPager.getAdapter();
                pagerFragAdapter.getBlankFragment().setLabel();

            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        PagerFragAdapter pagerFragAdapter = (PagerFragAdapter) viewPager.getAdapter();
                        pagerFragAdapter.getBlankFragment().setLabel();
                    }
                }, 2000);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }
}
