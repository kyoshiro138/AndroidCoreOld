package com.jp.androidcore.app.test;

import android.view.View;

import com.jp.androidcore.R;
import com.jp.androidcore.appimplemetation.activity.drawer.AppDrawerActivity;
import com.jp.androidcore.appimplemetation.fragment.AppFragment;

public class TestFragment2 extends AppFragment<AppDrawerActivity> {
    @Override
    protected int getFragmentLayoutResource() {
        return R.layout.fragment_test;
    }

    @Override
    protected void bindView(View rootView) {
        rootView.setBackgroundResource(R.color.c_debug_solid_green);
    }

    @Override
    protected void loadData() {

    }
}
