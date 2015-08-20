package com.jp.androidcore.app.animation;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jp.androidcore.R;
import com.jp.androidcore.appimplemetation.activity.drawer.AppDrawerActivity;
import com.jp.androidcore.appimplemetation.fragment.AppFragment;

public class AnimationFragment extends AppFragment<AppDrawerActivity> implements View.OnClickListener {
    private View mAnimationView;

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
                startAnimation(mAnimationView);
                break;
            default:
                break;
        }
    }

    private void startAnimation(final View view) {
        final int viewWidth = view.getMeasuredWidth();
        final int viewHeight = view.getMeasuredHeight();
        final float viewY = view.getY();

        Toast.makeText(getActivity(), String.format("view %d %d", viewWidth, viewHeight), Toast.LENGTH_SHORT).show();

        ValueAnimator widthAnimation = ValueAnimator.ofInt(0, 100);
        widthAnimation.setDuration(1000);
        widthAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();

                int width = viewWidth * val / 100;
                int height = viewHeight * val / 100;
                float y = viewY + ((viewHeight - height) / 2);

                layoutParams.width = width;
                layoutParams.height = height;

                view.setLayoutParams(layoutParams);
                view.setY(y);
            }
        });
        widthAnimation.start();
    }
}
