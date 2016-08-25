package cn.mrxus.ym.ui;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import cn.mrxus.ym.R;

/**
 * Created by mrxus on 16/8/25.
 */
public class DatePickerDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.Dialog_NoTitle);
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_date_picker, null);
        builder.setCancelable(true);
        builder.setView(view);

        AlertDialog dialog = builder.create();

        dialog.setCanceledOnTouchOutside(true);

        Window window = dialog.getWindow();
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.gravity= Gravity.BOTTOM;
        window.setAttributes(wl);

        return dialog;


    }
}
