package com.jp.androidcore.app.dialog;

import android.view.View;

import com.jp.androidcore.R;
import com.jp.androidcore.appimplemetation.activity.drawer.AppDrawerActivity;
import com.jp.androidcore.appimplemetation.dialog.AppDialogBuilder;
import com.jp.androidcore.appimplemetation.fragment.AppFragment;
import com.jp.androidcore.core.dialog.Dialog;
import com.jp.androidcore.core.dialog.OnDialogButtonClickListener;
import com.jp.androidcore.core.dialog.progress.OnProgressWithResultListener;
import com.jp.androidcore.core.dialog.progress.SystemProgressDialog;

public class DialogSampleFragment extends AppFragment<AppDrawerActivity>
        implements View.OnClickListener, OnProgressWithResultListener<String>,OnDialogButtonClickListener {
    private AppDialogBuilder mDialogBuilder;

    @Override
    protected int getFragmentLayoutResource() {
        return R.layout.fragment_dialog_sample;
    }

    @Override
    protected void bindView(View rootView) {
        rootView.findViewById(R.id.btn_show_progress_dialog).setOnClickListener(this);
        rootView.findViewById(R.id.btn_show_alert_dialog).setOnClickListener(this);
        rootView.findViewById(R.id.btn_show_confirm_dialog).setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        mDialogBuilder = new AppDialogBuilder(getActivity());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show_progress_dialog:
                showProgressDialog();
                break;
            case R.id.btn_show_alert_dialog:
                showAlertDialog();
                break;
            case R.id.btn_show_confirm_dialog:
                showConfirmDialog();
                break;
            default:
                break;
        }
    }

    private void showConfirmDialog() {

    }

    private void showAlertDialog() {
        Dialog dialog = mDialogBuilder.buildSystemDialog("AlertDialog", this);
        dialog.show();
    }

    private void showProgressDialog() {
        SystemProgressDialog<String> dialog = (SystemProgressDialog<String>) mDialogBuilder.buildProgressDialog("ProgressDialog", "Progressing...!");
        dialog.startProgressWithResult(this);
    }

    @Override
    public String onProgressBackgroundWithResult(String tag) {
        logDebug("DIALOG PROGRESSING FOR 5 SECONDS");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onProgressFinished(String tag, String s) {
        logDebug("UPDATE UI");
    }

    @Override
    public void onClick(Dialog dialog, int which) {

    }
}
