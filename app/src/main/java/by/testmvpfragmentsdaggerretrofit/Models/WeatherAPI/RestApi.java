package by.testmvpfragmentsdaggerretrofit.Models.WeatherAPI;


import by.testmvpfragmentsdaggerretrofit.Models.DataModel.WeatherIdCity;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {


    @GET("data/2.5/weather")
    Observable<WeatherIdCity> getWeatherIdCity(@Query("id") String idCity, @Query("appid") String weatherApiKey, @Query("units") String units);

    /*units=metric*/

}
