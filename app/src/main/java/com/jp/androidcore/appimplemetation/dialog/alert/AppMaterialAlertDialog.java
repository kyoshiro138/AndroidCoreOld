package com.jp.androidcore.appimplemetation.dialog.alert;

import android.content.Context;
import android.view.View;

import com.jp.androidcore.R;
import com.jp.androidcore.core.dialog.alert.BaseCustomAlertDialog;

public class AppMaterialAlertDialog extends BaseCustomAlertDialog {
    @Override
    protected int getDialogLayoutResource() {
        return R.layout.dialog_material_alert;
    }

    protected AppMaterialAlertDialog(Context context) {
        super(context);
    }

    protected AppMaterialAlertDialog(Context context, int theme) {
        super(context, theme);
    }

    protected AppMaterialAlertDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void bindDialogView(View rootView) {
        bindTitle(rootView, R.id.dialog_title_text);
        bindMessage(rootView, R.id.dialog_message_text);
        bindButton(rootView, BUTTON_POSITIVE, R.id.dialog_positive_button);
        bindButton(rootView, BUTTON_NEGATIVE, R.id.dialog_negative_button);
    }
}
