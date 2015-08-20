package com.jp.androidcore.app.animation;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jp.androidcore.R;
import com.jp.androidcore.appimplemetation.activity.drawer.AppDrawerActivity;
import com.jp.androidcore.appimplemetation.fragment.AppFragment;
import com.jp.androidcore.core.animation.AppearAnimator;

public class AnimationFragment extends AppFragment<AppDrawerActivity> implements View.OnClickListener {
    private View mAnimationView;
    private AppearAnimator mAppearAnimation;

    @Override
    protected int getFragmentLayoutResource() {
        return R.layout.fragment_animation;
    }

    @Override
    protected void bindView(View rootView) {
        mAnimationView = rootView.findViewById(R.id.view_animation);

        rootView.findViewById(R.id.btn_animation_appear).setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_animation_appear:
                if(mAppearAnimation == null) {
                    mAppearAnimation = new AppearAnimator(mAnimationView, "APPEAR");
                }
                mAppearAnimation.start();
                break;
            default:
                break;
        }
    }
}
