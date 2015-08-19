package com.jp.androidcore.appimplemetation.activity;

import com.jp.androidcore.R;
import com.jp.androidcore.app.activitylist.ActivityListFragment;
import com.jp.androidcore.appimplemetation.navigator.AppNavigator;
import com.jp.androidcore.core.activity.BaseFragmentActivity;
import com.jp.androidcore.core.navigator.NavigationActivity;

public class AppFragmentActivity extends BaseFragmentActivity
        implements NavigationActivity<AppNavigator> {
    @Override
    protected int getActivityLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected int getContentFragmentId() {
        return R.id.layout_screen_content;
    }

    private AppNavigator mNavigator;

    @Override
    public AppNavigator getNavigator() {
        if (mNavigator == null) {
            mNavigator = new AppNavigator(getContentFragmentId(), getSupportFragmentManager(), null);
        }
        return mNavigator;
    }

    @Override
    protected void initContentFragment() {
        getNavigator().navigateToFirstLevelFragment(new ActivityListFragment(), null);
    }
}
