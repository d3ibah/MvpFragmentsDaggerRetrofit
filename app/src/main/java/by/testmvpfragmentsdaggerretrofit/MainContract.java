package by.testmvpfragmentsdaggerretrofit;

public interface MainContract {

    interface View {

        interface MainActivityView{
            void showFragment();
        }

        interface PasswordView {
            void showOrHidePassword();
            void showIdentificationFragment();
        }

        interface IdentificationView {

            void showInfo();
            void showOrHideKey();
            void goToWeatherActivity();
            void goBack();
        }

        interface Dialog1Int {
            void finishDialog();
            void showDialog2();
        }

        interface Dialog2Int {
            void closeDialog();
        }
    }

    interface Presenter {

        interface MainActivityPresenter{
            void onShowFragment();
        }

        interface PasswordPr {
            void onButtonWasClicked();
            void onImageVisibilityWasClicked();
        }

        interface IdentificationPr {
            void onInfoWasClicked();
            void onShowOrHideWasClicked();
            void onButtonWasClicked();
            void onGoBackWasClicked();
        }

        interface Dialog1Pr {
            void onButtonYesWasClicked();
            void onButtoNoWasClicked();
        }

        interface Dialog2Pr {
            void onButtonWasClicked();
        }
    }

    interface Model {
        String loadMessage();
    }
}
