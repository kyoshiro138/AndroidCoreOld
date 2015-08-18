package com.jp.androidcore.core.dialog.alert;

import android.content.Context;

public class SystemAlertDialog extends BaseAlertDialog {

    public SystemAlertDialog(Context context) {
        super(context);
    }

    public SystemAlertDialog(Context context, int theme) {
        super(context, theme);
    }

    public SystemAlertDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void initDialog(Context context) {
        super.initDialog(context);

        setCanceledOnTouchOutside(true);
        setButton(BUTTON_POSITIVE, "OK");
    }
}
