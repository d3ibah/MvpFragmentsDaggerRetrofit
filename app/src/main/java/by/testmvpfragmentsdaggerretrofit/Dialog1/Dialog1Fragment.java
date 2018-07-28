package by.testmvpfragmentsdaggerretrofit.Dialog1;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import by.testmvpfragmentsdaggerretrofit.Dialog2.Dialog2Fragment;
import by.testmvpfragmentsdaggerretrofit.MainContract;
import by.testmvpfragmentsdaggerretrofit.R;

public class Dialog1Fragment extends DialogFragment implements MainContract.View.Dialog1Int{

    private Dialog1Presenter dialog1Presenter;

    Button buttonYes, buttonNo;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_1, null);
        builder.setView(view);

        buttonYes = view.findViewById(R.id.sms_btn_yes);
        buttonNo = view.findViewById(R.id.sms_btn_no);

        dialog1Presenter = new Dialog1Presenter(this);

        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1Presenter.onButtonYesWasClicked();
            }
        });

        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog1Presenter.onButtoNoWasClicked();
            }
        });
        return builder.create();
    }

    @Override
    public void finishDialog() {
        onDestroyView();
    }

    @Override
    public void showDialog2() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        Dialog2Fragment dialog2Fragment = new Dialog2Fragment();

        FragmentTransaction transaction = manager.beginTransaction();
        dialog2Fragment.show(transaction, "dialog1");
    }
}
