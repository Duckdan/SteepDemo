package com.study.yang.fiveandsixstyleapp;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Style6DetailActivity extends AppCompatActivity {

    @BindView(R.id.toobar)
    Toolbar mToobar;
    @BindView(R.id.appBar)
    AppBarLayout mAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style6_detail);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT &&
                Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT_WATCH) {
            int padding = DensityUtil.px2dip(this, 25);
//            mToobar.setPadding(0,padding,0,0);
            ViewGroup.LayoutParams layoutParams = mToobar.getLayoutParams();
            layoutParams.height = layoutParams.height + padding;
            mToobar.setLayoutParams(layoutParams);
            mToobar.setTitleMarginTop(padding);

            mAppBar.setFitsSystemWindows(false);
//            mTl.setPadding(0,padding,0,0);
//            //将侧边栏顶部延伸至status bar
//            mActivityStyle6.setFitsSystemWindows(true);
//            //将主页面顶部延伸至status bar;虽默认为false,但经测试,DrawerLayout需显示设置
//            mActivityStyle6.setClipToPadding(false);
        }

    }
}
