package com.jp.androidcore.appimplemetation.fragment;

import android.app.Activity;
import android.os.Parcelable;

import com.jp.androidcore.appimplemetation.activity.AppFragmentActivity;
import com.jp.androidcore.core.navigator.BaseParamFragment;
import com.jp.androidcore.core.navigator.Navigable;
import com.jp.androidcore.core.navigator.NavigationFragment;

public abstract class AppParamFragment<TParam extends Parcelable>
        extends BaseParamFragment<TParam>
        implements NavigationFragment<AppFragmentActivity> {
    protected AppFragmentActivity mActivity;

    @Override
    public AppFragmentActivity getNavigationActivity() {
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

        mActivity = (AppFragmentActivity) activity;
    }
}
