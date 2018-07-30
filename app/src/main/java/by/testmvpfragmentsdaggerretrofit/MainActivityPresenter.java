package by.testmvpfragmentsdaggerretrofit;

import by.testmvpfragmentsdaggerretrofit.Models.Model;

public class MainActivityPresenter implements MainContract.Presenter.MainActivityPresenter{

    private MainContract.View.MainActivityView mainActivityView;
    private MainContract.Model model;

    public MainActivityPresenter(MainContract.View.MainActivityView mainActivityView) {
        this.mainActivityView = mainActivityView;
        this.model = new Model();
    }

    @Override
    public void onShowFragment(boolean addToBackStack) {
        mainActivityView.showFragment(addToBackStack);
    }
}
