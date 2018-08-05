package by.testmvpfragmentsdaggerretrofit;


public class MainActivityPresenter implements MainContract.Presenter.MainActivityPresenter{

    private MainContract.View.MainActivityView mainActivityView;

    public MainActivityPresenter(MainContract.View.MainActivityView mainActivityView) {
        this.mainActivityView = mainActivityView;
    }

    @Override
    public void onShowFragment(boolean addToBackStack) {
        mainActivityView.showFragment(addToBackStack);
    }
}
