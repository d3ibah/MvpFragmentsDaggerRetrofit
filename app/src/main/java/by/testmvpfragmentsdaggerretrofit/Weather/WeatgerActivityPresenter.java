package by.testmvpfragmentsdaggerretrofit.Weather;

import javax.inject.Inject;

import by.testmvpfragmentsdaggerretrofit.App;
import by.testmvpfragmentsdaggerretrofit.MainContract;
import by.testmvpfragmentsdaggerretrofit.Models.DataModel.WeatherIdCity;
import by.testmvpfragmentsdaggerretrofit.Models.WeatherAPI.RestApi;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WeatgerActivityPresenter implements MainContract.Presenter.WeatherActivityPresenter, Observer<WeatherIdCity> {

    private MainContract.View.WeatherActivityView weatherView;

    @Inject
    RestApi restService;

    public final static String KEY = "caca802f25ade93761f49c8f818f1caf";
    public final static String UNITS = "metric";
    public final static String ID_CITY = "625144";

    public WeatgerActivityPresenter(MainContract.View.WeatherActivityView weatherView) {
        App.getAppComponent().inject(this);
        this.weatherView = weatherView;
    }


    @Override
    public void onStartedShowWeather() {
        restService.getWeatherIdCity(ID_CITY, KEY, UNITS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(this);
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(WeatherIdCity weatherIdCity) {
        weatherView.showWeather(weatherIdCity);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
