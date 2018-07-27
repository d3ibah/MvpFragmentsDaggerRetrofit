package by.testmvpfragmentsdaggerretrofit.Identification;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import by.testmvpfragmentsdaggerretrofit.Dialog1.Dialog1Fragment;
import by.testmvpfragmentsdaggerretrofit.MainContract;
import by.testmvpfragmentsdaggerretrofit.R;

public class IdentificationFragment extends Fragment implements MainContract.View.IdentificationView {

    private Toolbar toolbar;
    private TextView tvIdNum;
    private EditText etIdNum, etIdKey;
    private ImageView ivWarning, ivInfo, ivVisibility;
    private Button btnResume;

    boolean flagShowPass = false;

    private MainContract.Presenter.IdentificationPr identificationPresenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_identification, container, false);

        identificationPresenter = new IdentificationPresenter(this);
        toolbar = rootView.findViewById(R.id.toolbar_id);
        tvIdNum = rootView.findViewById(R.id.tv_id_idnum);
        etIdNum = rootView.findViewById(R.id.editText_id_idnum);
        etIdKey = rootView.findViewById(R.id.editText_id_key);
        ivWarning = rootView.findViewById(R.id.iv_show_warning);
        ivInfo = rootView.findViewById(R.id.iv_show_info);
        ivVisibility = rootView.findViewById(R.id.iv_show_pass);
        btnResume = rootView.findViewById(R.id.btn_id_resume);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                identificationPresenter.onGoBackWasClicked();
            }
        });

        ivVisibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                identificationPresenter.onShowOrHideWasClicked();
            }
        });

        ivInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                identificationPresenter.onInfoWasClicked();
            }
        });


        return rootView;
    }

    @Override
    public void showInfo() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        Dialog1Fragment dialog1Fragment = new Dialog1Fragment();

        FragmentTransaction transaction = manager.beginTransaction();
        dialog1Fragment.show(transaction, "dialog1");
    }

    @Override
    public void showOrHidePassword() {
        if (!flagShowPass) {
            ivVisibility.setImageResource(R.drawable.ic_visibility_black_24dp);
            etIdKey.setTransformationMethod(null);
            etIdKey.setSelection(etIdKey.length());
            flagShowPass = !flagShowPass;
        } else {
            ivVisibility.setImageResource(R.drawable.ic_visibility_off_black_24dp);
            flagShowPass = !flagShowPass;
            etIdKey.setTransformationMethod(new PasswordTransformationMethod());
        }
    }

    @Override
    public void goToWeatherActivity() {

    }

    @Override
    public void goBack() {
        getActivity().onBackPressed();
    }
}