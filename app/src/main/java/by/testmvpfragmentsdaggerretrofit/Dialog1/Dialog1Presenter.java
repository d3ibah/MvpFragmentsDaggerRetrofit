package by.testmvpfragmentsdaggerretrofit.Dialog1;

import by.testmvpfragmentsdaggerretrofit.MainContract;
import by.testmvpfragmentsdaggerretrofit.Models.Model;

public class Dialog1Presenter implements MainContract.Presenter.Dialog1Pr{

    private MainContract.View.Dialog1Int dialog1View;
    private MainContract.Model model;

    public Dialog1Presenter(MainContract.View.Dialog1Int dialog1View) {
        this.dialog1View = dialog1View;
        this.model = new Model();
    }


    @Override
    public void onButtonYesWasClicked() {
        dialog1View.finishDialog();
    }

    @Override
    public void onButtoNoWasClicked() {
        dialog1View.showDialog2();
    }
}
