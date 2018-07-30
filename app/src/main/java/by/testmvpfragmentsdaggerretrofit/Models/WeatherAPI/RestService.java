package by.testmvpfragmentsdaggerretrofit.Models.WeatherAPI;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RestService {

    private RestApi restApi;


    @Inject
    public RestService(RestApi restApi){
        this.restApi = restApi;
    }

}
