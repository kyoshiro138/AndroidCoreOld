package com.jp.androidcore.appimplemetation.activity.drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.jp.androidcore.R;
import com.jp.androidcore.app.menu.MenuFragment;
import com.jp.androidcore.appimplemetation.activity.toolbar.AppToolbarViewHolder;
import com.jp.androidcore.appimplemetation.navigator.AppNavigator;
import com.jp.androidcore.core.activity.drawer.BaseDrawerActivity;
import com.jp.androidcore.core.activity.toolbar.ToolbarActivity;
import com.jp.androidcore.core.navigator.NavigationActivity;
import com.jp.androidcore.core.navigator.menu.MenuActivity;
import com.jp.androidcore.core.navigator.menu.OnMenuClosedListener;

public class AppDrawerActivity extends BaseDrawerActivity
        implements NavigationActivity<AppNavigator>,
        ToolbarActivity<AppToolbarViewHolder>,
        MenuActivity {
    private AppNavigator mNavigator;
    private OnMenuClosedListener mListener;
    private AppToolbarViewHolder mToolbar;

    @Override
    protected int getActivityLayoutResource() {
        return R.layout.activity_navigation_drawer;
    }

    @Override
    protected int getDrawerLayoutId() {
        return R.id.drawer_layout;
    }

    @Override
    protected int getContentFragmentId() {
        return R.id.layout_screen_content;
    }

    @Override
    protected int getMenuLayoutId() {
        return R.id.layout_screen_menu;
    }

    @Override
    protected Fragment getDrawerMenuFragment() {
        return new MenuFragment();
    }

    @Override
    public AppNavigator getNavigator() {
        if (mNavigator == null) {
            mNavigator = new AppNavigator(getContentFragmentId(), getSupportFragmentManager(), this);
        }
        return mNavigator;
    }

    @Override
    public AppToolbarViewHolder getToolbar() {
        if (mToolbar == null) {
            View toolbarView = findViewById(R.id.toolbar_layout);
            mToolbar = new AppToolbarViewHolder(this, toolbarView);
        }
        return mToolbar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void closeMenu(OnMenuClosedListener listener) {
        mListener = listener;
        if (isDrawerOpened()) {
            closeDrawer();
        } else {
            if (mListener != null) {
                mListener.onClosed();
                mListener = null;
            }
        }
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        super.onDrawerClosed(drawerView);
        if (mListener != null) {
            mListener.onClosed();
            mListener = null;
        }
    }
}
