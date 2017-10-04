package com.study.yang.fiveandsixstyleapp;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Style6Activity extends AppCompatActivity {

    @BindView(R.id.toobar)
    Toolbar mToobar;
    @BindView(R.id.tl)
    TabLayout mTl;
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.activity_style6)
    DrawerLayout mActivityStyle6;
    private ActionBarDrawerToggle mToggle;
    private List<CardListFragment> lists = new ArrayList<>();
    private String[] names = {"Tab1", "Tab2", "Tab3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.activity_style6);
        ButterKnife.bind(this);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT&&
                Build.VERSION.SDK_INT<=Build.VERSION_CODES.KITKAT_WATCH){
            int padding = DensityUtil.px2dip(this, 25);
            mToobar.setPadding(0,padding,0,0);
            mTl.setPadding(0,padding,0,0);
            //将侧边栏顶部延伸至status bar
            mActivityStyle6.setFitsSystemWindows(true);
            //将主页面顶部延伸至status bar;虽默认为false,但经测试,DrawerLayout需显示设置
            mActivityStyle6.setClipToPadding(false);
       }

        setSupportActionBar(mToobar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mToggle = new ActionBarDrawerToggle(this, mActivityStyle6, R.string.app_name, R.string.app_name);
        mToggle.syncState();
        mActivityStyle6.addDrawerListener(mToggle);

        lists.add(new CardListFragment());
        lists.add(new CardListFragment());
        lists.add(new CardListFragment());

        mVp.setAdapter(new VpAdapter(getSupportFragmentManager()));
        mTl.setupWithViewPager(mVp);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class VpAdapter extends FragmentPagerAdapter {

        public VpAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return lists.get(position);
        }

        @Override
        public int getCount() {
            return lists.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return names[position];
        }
    }
}
