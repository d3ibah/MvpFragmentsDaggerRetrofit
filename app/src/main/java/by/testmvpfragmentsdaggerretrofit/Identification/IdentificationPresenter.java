package by.testmvpfragmentsdaggerretrofit.Identification;

import by.testmvpfragmentsdaggerretrofit.MainContract;

public class IdentificationPresenter implements MainContract.Presenter.IdentificationPr{

    private MainContract.View.IdentificationView identificationView;

    public IdentificationPresenter(MainContract.View.IdentificationView identificationView) {
        this.identificationView = identificationView;
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
