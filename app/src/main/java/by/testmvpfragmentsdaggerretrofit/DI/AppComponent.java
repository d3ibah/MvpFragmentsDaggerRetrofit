package by.testmvpfragmentsdaggerretrofit.DI;

import javax.inject.Singleton;

import by.testmvpfragmentsdaggerretrofit.Weather.WeatgerActivityPresenter;

import dagger.Component;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    void inject(WeatgerActivityPresenter modelWeather);
}
