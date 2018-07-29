package by.testmvpfragmentsdaggerretrofit.Models.WeatherAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Singleton
public class RestService {

//    public static final String BASE_URL = "https://api.openweathermap.org/";
//    private static RestService instance;
    public RestApi restApi;


    @Inject
    public RestService(RestApi restApi){
        this.restApi = restApi;
    }

//    private RestService() {
//        init();
//    }
//
//    public static RestService getInstance(){
//        if(instance == null){
//            instance = new RestService();
//        }
//    return instance;
//    }

//    public RestApi getRestApi(){
//        return restApi;
//    }
//
//    private void init(){
//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .readTimeout(20, TimeUnit.SECONDS)
//                .connectTimeout(10, java.util.concurrent.TimeUnit.SECONDS)
//                .addInterceptor(loggingInterceptor)
//                .build();
//
//        Gson gson = new GsonBuilder().create();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .client(okHttpClient)
//                .build();
//
//        restApi = retrofit.create(RestApi.class);
//    }
}
