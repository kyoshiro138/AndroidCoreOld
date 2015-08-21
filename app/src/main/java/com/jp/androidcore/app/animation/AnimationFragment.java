package com.jp.androidcore.app.animation;

import android.view.View;

import com.jp.androidcore.R;
import com.jp.androidcore.appimplemetation.activity.drawer.AppDrawerActivity;
import com.jp.androidcore.appimplemetation.fragment.AppFragment;
import com.jp.androidcore.core.animation.FadeOutAnimator;
import com.jp.androidcore.core.animation.ZoomInAnimator;
import com.jp.androidcore.core.animation.ZoomOutAnimator;

public class AnimationFragment extends AppFragment<AppDrawerActivity> implements View.OnClickListener {
    private View mAnimationView;
    private ZoomInAnimator mZoomOutAnimator;
    private FadeOutAnimator mFadeOutAnimator;

    @Override
    protected int getFragmentLayoutResource() {
        return R.layout.fragment_animation;
    }

    @Override
    protected void bindView(View rootView) {
        mAnimationView = rootView.findViewById(R.id.view_animation);

        rootView.findViewById(R.id.btn_animation_zoom_out).setOnClickListener(this);
        rootView.findViewById(R.id.btn_animation_fade_out).setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_animation_zoom_out:
                if (mZoomOutAnimator == null) {
                    mZoomOutAnimator = new ZoomInAnimator(mAnimationView);
                }
                mZoomOutAnimator.start();
                break;
            case R.id.btn_animation_fade_out:
                if (mFadeOutAnimator == null) {
                    mFadeOutAnimator = new FadeOutAnimator(mAnimationView);
                }
                mFadeOutAnimator.start();
                break;
            default:
                break;
        }
    }
}
