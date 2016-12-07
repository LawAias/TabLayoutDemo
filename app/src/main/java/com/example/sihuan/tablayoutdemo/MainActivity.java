package com.example.sihuan.tablayoutdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initFragments();
        initViews();
    }

    TabLayout tabLayout;
    ViewPager viewPager;

    private void findViews() {
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

    }

    List<Fragment> fragments;
    List<String> titles;

    private void initFragments() {
        fragments = new ArrayList<>();
        titles = new ArrayList<>();
        fragments.add(MyFragment.newInstance("第一个fragment"));
        fragments.add(MyFragment.newInstance("第二个Fragment"));
        titles.add("ftm1");
        titles.add("ftm2");
    }


    private void initViews() {
//        tabLayout.addTab(tabLayout.newTab().setText("ftm1"));
//        tabLayout.addTab(tabLayout.newTab().setText("ftm2"));
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments == null ? 0 : fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }
}
