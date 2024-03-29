package com.jp.androidcore.core.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;

public abstract class BaseAnimator implements Animator.AnimatorListener {
    protected View mAnimationView;
    protected String mTag;
    private Animator mAnimator;

    public BaseAnimator(View view) {
        mAnimationView = view;
        mTag = this.getClass().getSimpleName();

        mAnimator = initAnimation(mAnimationView);
        mAnimator.addListener(this);
    }

    public BaseAnimator(View view, String tag) {
        mAnimationView = view;
        mTag = tag;

        mAnimator = initAnimation(mAnimationView);
        mAnimator.addListener(this);
    }

    protected abstract Animator initAnimation(View view);

    public void start() {
        if (mAnimator != null && !mAnimator.isRunning()) {
            mAnimator.start();
        }
    }

    public void setDuration(long milliseconds) {
        if (mAnimator != null) {
            mAnimator.setDuration(milliseconds);
        }
    }

    public void setInterpolator(TimeInterpolator interpolator) {
        if (mAnimator != null) {
            mAnimator.setInterpolator(interpolator);
        }
    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {

    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
