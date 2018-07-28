package by.testmvpfragmentsdaggerretrofit.Dialog2;

import by.testmvpfragmentsdaggerretrofit.MainContract;
import by.testmvpfragmentsdaggerretrofit.Model;

public class Dialog2Presenter implements MainContract.Presenter.Dialog2Pr{

    private MainContract.View.Dialog2Int dialog2View;
    private MainContract.Model model;

    public Dialog2Presenter(MainContract.View.Dialog2Int dialog2View) {
        this.dialog2View = dialog2View;
        this.model = new Model();
    }


    @Override
    public void onButtonWasClicked() {
        dialog2View.closeDialog();
    }
}
