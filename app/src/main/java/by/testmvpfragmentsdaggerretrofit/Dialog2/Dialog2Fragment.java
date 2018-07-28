package by.testmvpfragmentsdaggerretrofit.Dialog2;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import by.testmvpfragmentsdaggerretrofit.MainContract;
import by.testmvpfragmentsdaggerretrofit.R;

public class Dialog2Fragment extends DialogFragment implements MainContract.View.Dialog2Int{

    private Dialog2Presenter dialog2Presenter;

    private Button buttonSend;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_2, null);
        builder.setView(view);

        dialog2Presenter = new Dialog2Presenter(this);
        buttonSend = view.findViewById(R.id.tel_btn_send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog2Presenter.onButtonWasClicked();
            }
        });
        return builder.create();
    }

    @Override
    public void closeDialog() {
        onDestroyView();
    }
}
