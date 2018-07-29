package by.testmvpfragmentsdaggerretrofit.DI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import by.testmvpfragmentsdaggerretrofit.Models.WeatherAPI.RestApi;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class AppModule {

        public static final String BASE_URL = "https://api.openweathermap.org/";

        @Provides
        @Singleton
        RestApi provideRestApi(Retrofit retrofit) {
            return retrofit.create(RestApi.class);
        }

        @Provides
        @Singleton
        Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
            return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();
        }

        @Provides
        @Singleton
        OkHttpClient provideOkHttpClient(HttpLoggingInterceptor logging) {
            return new OkHttpClient.Builder()
                    .readTimeout(20, TimeUnit.SECONDS)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .addInterceptor(logging)
                    .build();
        }

        @Provides
        @Singleton
        HttpLoggingInterceptor provideLogging() {
            return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        }

        @Provides
        @Singleton
        Gson provideGson() {
            return new GsonBuilder().create();
        }

    }
