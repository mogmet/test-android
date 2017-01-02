package com.mogmet.test;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mogmet on 2017/01/02.
 */

public final class InputDialogFragment extends DialogFragment {
    @BindView(R.id.title_edit_text)
    EditText titleEditText;
    private Listener listener;

    public static InputDialogFragment newInstance() {
        return new InputDialogFragment();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View content = inflater.inflate(R.layout.dialog_input, null);
        ButterKnife.bind(this, content);
        listener = (Listener) getActivity();
        builder.setView(content);
        builder.setTitle("端末登録");
        builder.setMessage("初回のみ端末登録のために、ログイン情報を入力してください");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (listener != null) {
                    listener.dialogClicked(titleEditText.getText().toString());
                }
            }
        });
        return builder.create();
    }

    public interface Listener {
        void dialogClicked(String message);
    }
}

