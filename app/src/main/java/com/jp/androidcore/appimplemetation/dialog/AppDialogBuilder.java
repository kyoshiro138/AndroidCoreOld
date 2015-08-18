package com.jp.androidcore.appimplemetation.dialog;

import android.content.Context;
import android.content.DialogInterface;

import com.jp.androidcore.core.dialog.Dialog;
import com.jp.androidcore.core.dialog.OnDialogButtonClickListener;
import com.jp.androidcore.core.dialog.alert.SystemAlertDialog;
import com.jp.androidcore.core.dialog.progress.SystemProgressDialog;

public class AppDialogBuilder {
    private Dialog mCurrentActiveDialog = null;
    private Context mContext;

    public Dialog getCurrentActiveDialog() {
        return mCurrentActiveDialog;
    }

    public AppDialogBuilder(Context context) {
        mContext = context;
    }

    public Dialog buildSystemDialog(String tag, OnDialogButtonClickListener onClickListener) {
        if (mCurrentActiveDialog != null && mCurrentActiveDialog.getTag().equals(tag)) {
            return mCurrentActiveDialog;
        } else {
            SystemAlertDialog dialog = new SystemAlertDialog(mContext);

            dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK");
            dialog.setTag(tag);
            dialog.setOnButtonClickListener(onClickListener);

            mCurrentActiveDialog = dialog;
            return dialog;
        }
    }

    public Dialog buildProgressDialog(String tag, String progressMessage) {
        if (mCurrentActiveDialog != null && mCurrentActiveDialog.getTag().equals(tag)) {
            return mCurrentActiveDialog;
        } else {
            SystemProgressDialog<String> dialog = new SystemProgressDialog<>(mContext);
            dialog.setMessage(progressMessage);

            mCurrentActiveDialog = dialog;
            return dialog;
        }
    }

    public void dispose() {
        mCurrentActiveDialog = null;
    }
}
