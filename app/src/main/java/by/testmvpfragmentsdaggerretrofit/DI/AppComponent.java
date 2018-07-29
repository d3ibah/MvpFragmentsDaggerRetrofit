package by.testmvpfragmentsdaggerretrofit.DI;

import javax.inject.Singleton;

import by.testmvpfragmentsdaggerretrofit.WeatherActivity;
import dagger.Component;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    void inject(WeatherActivity weatherActivity);
}
