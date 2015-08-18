package com.jp.androidcore.app.activitylist;

import android.content.Intent;
import android.view.View;

import com.jp.androidcore.R;
import com.jp.androidcore.appimplemetation.activity.AppFragmentActivity;
import com.jp.androidcore.appimplemetation.activity.drawer.AppDrawerActivity;
import com.jp.androidcore.appimplemetation.fragment.AppFragment;

public class ActivityListFragment extends AppFragment<AppFragmentActivity> implements View.OnClickListener {
    @Override
    protected int getFragmentLayoutResource() {
        return R.layout.fragment_activity_list;
    }

    @Override
    protected void bindView(View rootView) {
        rootView.findViewById(R.id.btn_navigate_drawer_activity).setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_navigate_drawer_activity:
                Intent intent = new Intent(mActivity, AppDrawerActivity.class);
                mActivity.startActivity(intent);
                break;
            default:
                break;
        }
    }
}
