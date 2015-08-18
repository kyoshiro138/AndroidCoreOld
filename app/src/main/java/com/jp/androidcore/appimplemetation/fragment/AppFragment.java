package com.jp.androidcore.appimplemetation.fragment;

import android.app.Activity;

import com.jp.androidcore.core.fragment.BaseFragment;
import com.jp.androidcore.core.navigator.Navigable;
import com.jp.androidcore.core.navigator.NavigationActivity;
import com.jp.androidcore.core.navigator.NavigationFragment;

public abstract class AppFragment<TActivity extends NavigationActivity> extends BaseFragment
        implements NavigationFragment<TActivity> {
    protected TActivity mActivity;

    @Override
    public TActivity getNavigationActivity() {
        return mActivity;
    }

    protected final Navigable getNavigator() {
        if (mActivity != null) {
            return mActivity.getNavigator();
        }
        return null;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mActivity = (TActivity) activity;
    }
}
