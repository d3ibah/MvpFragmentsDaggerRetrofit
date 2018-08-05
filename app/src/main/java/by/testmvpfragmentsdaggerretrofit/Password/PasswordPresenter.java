package by.testmvpfragmentsdaggerretrofit.Password;

import by.testmvpfragmentsdaggerretrofit.MainContract;

public class PasswordPresenter implements MainContract.Presenter.PasswordPr{

    private MainContract.View.PasswordView passwordView;

    public PasswordPresenter(MainContract.View.PasswordView passwordView) {
        this.passwordView = passwordView;
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
