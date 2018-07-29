package by.testmvpfragmentsdaggerretrofit.Identification;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
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

        AppCompatActivity appCompatActivity = ((AppCompatActivity) getActivity());
        appCompatActivity.setSupportActionBar(toolbar);

        ActionBar actionBar = appCompatActivity.getSupportActionBar();
        if (actionBar != null) {
            appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            appCompatActivity.getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

/*      Toolbar profile_toolbar = (Toolbar)view.findViewById(R.id.profile_toolbar);
        AppCompatActivity activity = (AppCompatActivity)getActivity();
        activity.setSupportActionBar(profile_toolbar);
        ActionBar actionBar = activity.getSupportActionBar();
        if(actionBar!= null) {
            actionBar.setTitle("dgdfg");
    }
    }*/

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

        btnResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                identificationPresenter.onButtonWasClicked();
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
    public void showOrHideKey() {
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
        btnResume.setEnabled(false);
        btnResume.setBackground(getActivity().getDrawable(R.drawable.button_gray_oval));
        tvIdNum.setText(getActivity().getText(R.string.id_tv_idnum_warning));
        tvIdNum.setTextColor(getActivity().getResources().getColor(R.color.colorWarning));
        ivWarning.setVisibility(View.VISIBLE);
        etIdNum.setHint(getActivity().getText(R.string.id_et_idnum_info));
        etIdNum.setFocusable(true);
        etIdNum.setSelection(etIdNum.length());

    }

    @Override
    public void goBack() {
        getActivity().onBackPressed();
    }
}
