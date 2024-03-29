package com.jp.androidcore.core.dialog.alert;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.jp.androidcore.core.dialog.Dialog;
import com.jp.androidcore.core.dialog.OnDialogButtonClickListener;

public abstract class BaseAlertDialog extends AlertDialog
        implements DialogInterface.OnClickListener, Dialog {

    private String mTag = "";
    private OnDialogButtonClickListener mListener;
    protected Context mContext;

    public void setTag(String tag) {
        mTag = tag;
    }

    public String getTag() {
        return mTag;
    }

    protected BaseAlertDialog(Context context) {
        super(context);
        initDialog(context);
    }

    protected BaseAlertDialog(Context context, int theme) {
        super(context, theme);
        initDialog(context);
    }

    protected BaseAlertDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initDialog(context);
    }

    protected void initDialog(Context context) {
        mContext = context;
        mTag = getClass().getSimpleName();
    }

    public void setMessage(int messageId) {
        setMessage(mContext.getText(messageId));
    }

    public void setButton(int whichButton, CharSequence text) {
        setButton(whichButton, text, this);
    }

    public void setButton(int whichButton, int textId) {
        setButton(whichButton, mContext.getText(textId), this);
    }

    public void setOnButtonClickListener(OnDialogButtonClickListener listener) {
        mListener = listener;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (mListener != null) {
            mListener.onClick(this, which);
        }

        dismiss();
    }
}
