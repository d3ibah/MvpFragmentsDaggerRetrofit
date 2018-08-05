package by.testmvpfragmentsdaggerretrofit.Dialog2;

import by.testmvpfragmentsdaggerretrofit.MainContract;

public class Dialog2Presenter implements MainContract.Presenter.Dialog2Pr{

    private MainContract.View.Dialog2Int dialog2View;

    public Dialog2Presenter(MainContract.View.Dialog2Int dialog2View) {
        this.dialog2View = dialog2View;
    }


    @Override
    public void onButtonWasClicked() {
        dialog2View.closeDialog();
    }
}
