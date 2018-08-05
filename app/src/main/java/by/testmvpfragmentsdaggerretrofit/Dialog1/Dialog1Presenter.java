package by.testmvpfragmentsdaggerretrofit.Dialog1;

import by.testmvpfragmentsdaggerretrofit.MainContract;

public class Dialog1Presenter implements MainContract.Presenter.Dialog1Pr{

    private MainContract.View.Dialog1Int dialog1View;

    public Dialog1Presenter(MainContract.View.Dialog1Int dialog1View) {
        this.dialog1View = dialog1View;
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
