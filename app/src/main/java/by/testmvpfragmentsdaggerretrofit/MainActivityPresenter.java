package by.testmvpfragmentsdaggerretrofit;

public class MainActivityPresenter implements MainContract.Presenter.MainActivityPresenter{

    private MainContract.View.MainActivityView mainActivityView;
    private MainContract.Model model;

    public MainActivityPresenter(MainContract.View.MainActivityView mainActivityView) {
        this.mainActivityView = mainActivityView;
        this.model = new Model();
    }

    @Override
    public void onShowFragment() {
        mainActivityView.showFragment();
    }
}
