package by.testmvpfragmentsdaggerretrofit;

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

public class MainActivity extends AppCompatActivity implements MainContract.View.MainActivityView{

    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainActivityPresenter(this);

        presenter.onShowFragment();

/*        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        PasswordFragment fragment = new PasswordFragment();
        fragmentTransaction.replace(R.id.container, fragment, null);
        fragmentTransaction.commit();*/

//        button.setEnabled(false);
//        button.setBackground(getDrawable(R.drawable.button_gray_oval));


    }

    @Override
    public void showFragment() {
        /*FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        IdentificationFragment fragment = new IdentificationFragment();
        fragmentTransaction.replace(R.id.container, fragment, null);
        fragmentTransaction.commit();*/

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        PasswordFragment fragment = new PasswordFragment();
        fragmentTransaction.replace(R.id.container, fragment, null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
