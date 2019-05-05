package com.latihan.dicoding.moviecataloguedicoding3.webService;

import com.latihan.dicoding.moviecataloguedicoding3.model.JSONResponse;
import com.latihan.dicoding.moviecataloguedicoding3.model.Movie;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("movie/now_playing")
    Call<JSONResponse> loadMovieData(@Query("api_key") String apiKey, @Query("language") String language);
}
