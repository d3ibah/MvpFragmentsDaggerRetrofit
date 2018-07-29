package by.testmvpfragmentsdaggerretrofit.Password;

import by.testmvpfragmentsdaggerretrofit.MainContract;
import by.testmvpfragmentsdaggerretrofit.Models.Model;

public class PasswordPresenter implements MainContract.Presenter.PasswordPr{

    private MainContract.View.PasswordView passwordView;
    private MainContract.Model model;

    public PasswordPresenter(MainContract.View.PasswordView passwordView) {
        this.passwordView = passwordView;
        this.model = new Model();
    }

    @Override
    public void onButtonWasClicked() {
        passwordView.showIdentificationFragment();
    }

    @Override
    public void onImageVisibilityWasClicked() {
        passwordView.showOrHidePassword();
    }
}
