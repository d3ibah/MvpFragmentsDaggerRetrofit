package by.testmvpfragmentsdaggerretrofit;

import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import by.testmvpfragmentsdaggerretrofit.Identification.IdentificationFragment;
import by.testmvpfragmentsdaggerretrofit.Password.PasswordFragment;

public class MainActivity extends AppCompatActivity implements MainContract.View.MainActivityView {

    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter(this);
        if (savedInstanceState == null) {
            presenter.onShowFragment(false);
        }
    }

    @Override
    public void showFragment(boolean addToBackStack) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        PasswordFragment fragment = new PasswordFragment();
        fragmentTransaction.replace(R.id.container, fragment, null);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}
