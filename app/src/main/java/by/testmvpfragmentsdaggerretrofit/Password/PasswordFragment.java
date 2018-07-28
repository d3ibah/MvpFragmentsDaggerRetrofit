package by.testmvpfragmentsdaggerretrofit.Password;

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

import by.testmvpfragmentsdaggerretrofit.Dialog1.Dialog1Fragment;
import by.testmvpfragmentsdaggerretrofit.Identification.IdentificationFragment;
import by.testmvpfragmentsdaggerretrofit.MainContract;
import by.testmvpfragmentsdaggerretrofit.R;

public class PasswordFragment extends Fragment implements MainContract.View.PasswordView {

    private Toolbar toolbar;
    private EditText etPassword;
    private ImageView ivVisiblePass;
    private Button btnResumeToId;

    boolean flagShowPass = false;

    private MainContract.Presenter.PasswordPr passwordPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_password, container, false);

        passwordPresenter = new PasswordPresenter(this);
        toolbar = rootView.findViewById(R.id.toolbar_pass);
        etPassword = rootView.findViewById(R.id.editText_pass_password);
        ivVisiblePass = rootView.findViewById(R.id.iv_show_pass);
        btnResumeToId = rootView.findViewById(R.id.btn_pass_resume);

        AppCompatActivity appCompatActivity = ((AppCompatActivity) getActivity());
        appCompatActivity.setSupportActionBar(toolbar);

        ivVisiblePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordPresenter.onImageVisibilityWasClicked();
            }
        });

        btnResumeToId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordPresenter.onButtonWasClicked();
            }
        });

        return rootView;


    }

    @Override
    public void showOrHidePassword() {
        if (!flagShowPass) {
            ivVisiblePass.setImageResource(R.drawable.ic_visibility_black_24dp);
            etPassword.setTransformationMethod(null);
            etPassword.setSelection(etPassword.length());
            flagShowPass = !flagShowPass;
        } else {
            ivVisiblePass.setImageResource(R.drawable.ic_visibility_off_black_24dp);
            flagShowPass = !flagShowPass;
            etPassword.setTransformationMethod(new PasswordTransformationMethod());
        }
    }

    @Override
    public void showIdentificationFragment() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        IdentificationFragment fragment = new IdentificationFragment();
        fragmentTransaction.replace(R.id.container, fragment, null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}


