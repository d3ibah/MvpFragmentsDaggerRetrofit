package by.testmvpfragmentsdaggerretrofit.Identification;

import by.testmvpfragmentsdaggerretrofit.MainContract;
import by.testmvpfragmentsdaggerretrofit.Model;

public class IdentificationPresenter implements MainContract.Presenter.IdentificationPr{

    private MainContract.View.IdentificationView identificationView;
    private MainContract.Model model;
    private String message;

    public IdentificationPresenter(MainContract.View.IdentificationView identificationView) {
        this.identificationView = identificationView;
        this.model = new Model();
    }


    @Override
    public void onInfoWasClicked() {
        identificationView.showInfo();
    }

    @Override
    public void onShowOrHideWasClicked() {
        identificationView.showOrHideKey();
    }

    @Override
    public void onButtonWasClicked() {
        identificationView.goToWeatherActivity();
    }

    @Override
    public void onGoBackWasClicked() {
        identificationView.goBack();
    }
}
