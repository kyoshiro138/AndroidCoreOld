package com.jp.androidcore.core.animation;

import android.view.View;

public class ViewAnimator {
    private View mAnimationView;
    private String mType;
    private String mTag;

    public ViewAnimator(View view, String animationType, String tag) {
        mAnimationView = view;
        mType = animationType;
        mTag = tag;

        initAnimation();
    }

    private void initAnimation() {
        switch (mType) {
            case "APPEAR":
                break;
            default:
                break;
        }
    }

    public void start() {

    }
}
