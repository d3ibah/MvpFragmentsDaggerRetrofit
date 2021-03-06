package by.testmvpfragmentsdaggerretrofit.Weather;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import javax.inject.Inject;

import by.testmvpfragmentsdaggerretrofit.App;
import by.testmvpfragmentsdaggerretrofit.MainContract;
import by.testmvpfragmentsdaggerretrofit.Models.DataModel.WeatherIdCity;
import by.testmvpfragmentsdaggerretrofit.Models.WeatherAPI.RestApi;
import by.testmvpfragmentsdaggerretrofit.Models.WeatherAPI.RestService;
import by.testmvpfragmentsdaggerretrofit.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class WeatherActivity extends AppCompatActivity implements MainContract.View.WeatherActivityView{

    private MainContract.Presenter.WeatherActivityPresenter weatherPresenter;


//    Disposable disposable;
//
//    @Inject
//    RestApi restService;
//
//    public final static String KEY = "caca802f25ade93761f49c8f818f1caf";
//    public final static String UNITS = "metric";
//    public final static String ID_CITY = "625144";

    private TextView textCity, textDegree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        textCity = findViewById(R.id.textView);
        textDegree = findViewById(R.id.textView2);
    }

    @Override
    protected void onStart() {
        super.onStart();

        weatherPresenter = new WeatgerActivityPresenter(this);
        weatherPresenter.onStartedShowWeather();




//        App.getAppComponent().inject(this);
//
//        disposable = restService.getWeatherIdCity(ID_CITY, KEY, UNITS)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new DisposableObserver<WeatherIdCity>() {
//                    @Override
//                    public void onNext(WeatherIdCity weatherIdCity) {
//                        textCity.setText(weatherIdCity.getName());
//                        textDegree.setText(weatherIdCity.getMain().getTemp());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }

    @Override
    public void showWeather(WeatherIdCity weatherIdCity) {
        textCity.setText(weatherIdCity.getName());
        textDegree.setText(weatherIdCity.getMain().getTemp());
    }

//    @Override
//    public void showWeather(WeatherIdCity weatherIdCity) {
//        textCity.setText(weatherIdCity.getName());
//        textDegree.setText(weatherIdCity.getMain().getTemp());
//    }
}
