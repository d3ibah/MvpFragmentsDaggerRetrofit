package by.testmvpfragmentsdaggerretrofit;

import android.app.Application;

import by.testmvpfragmentsdaggerretrofit.DI.AppComponent;
import by.testmvpfragmentsdaggerretrofit.DI.AppModule;
import by.testmvpfragmentsdaggerretrofit.DI.DaggerAppComponent;

public class App extends Application{

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initInjector();
    }

    private AppComponent initInjector(){
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();

        return appComponent;
    }
}
