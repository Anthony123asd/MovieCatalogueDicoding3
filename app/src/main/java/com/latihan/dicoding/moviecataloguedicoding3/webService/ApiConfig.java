package com.latihan.dicoding.moviecataloguedicoding3.webService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {
    public Retrofit retrofit() {
        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        final OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60L, TimeUnit.SECONDS)
                .writeTimeout(60L, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
        return new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public ApiInterface createInstance(){
        return retrofit().create(ApiInterface.class);
    }

}
