package com.jp.androidcore.app.menu;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jp.androidcore.R;
import com.jp.androidcore.app.dialog.DialogSampleFragment;
import com.jp.androidcore.app.test.TestFragment1;
import com.jp.androidcore.app.test.TestFragment2;
import com.jp.androidcore.appimplemetation.activity.drawer.AppDrawerActivity;
import com.jp.androidcore.appimplemetation.fragment.AppFragment;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends AppFragment<AppDrawerActivity> implements AdapterView.OnItemClickListener {
    private ListView mMenuList;

    @Override
    protected int getFragmentLayoutResource() {
        return R.layout.fragment_menu;
    }

    @Override
    protected void bindView(View rootView) {
        mMenuList = (ListView) mRootView.findViewById(R.id.list_menu);
        mMenuList.setOnItemClickListener(this);
    }

    @Override
    protected void loadData() {
        List<String> menuList = new ArrayList<>();
        menuList.add("Dialog");
        menuList.add("menu 2");

        MenuListAdapter menuListAdapter = new MenuListAdapter(mActivity, menuList);
        mMenuList.setAdapter(menuListAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                if (getNavigator() != null) {
                    getNavigator().navigateTo(new DialogSampleFragment(), null);
                }
                break;
            case 1:
                if (getNavigator() != null) {
                    getNavigator().navigateTo(new TestFragment2(), null);
                }
                break;
            default:
                break;
        }
    }
}
