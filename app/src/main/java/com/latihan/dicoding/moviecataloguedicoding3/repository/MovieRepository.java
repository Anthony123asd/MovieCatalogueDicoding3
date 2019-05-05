package com.latihan.dicoding.moviecataloguedicoding3.repository;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.latihan.dicoding.moviecataloguedicoding3.R;
import com.latihan.dicoding.moviecataloguedicoding3.model.JSONResponse;
import com.latihan.dicoding.moviecataloguedicoding3.webService.ApiConfig;
import com.latihan.dicoding.moviecataloguedicoding3.model.Movie;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private static MovieRepository instance;
    private static ArrayList<Movie> movies;
    private static final String API_KEY = "81d8f4353c2ade529071133972205017";
    private static String language;
    private static final String TAG = "repo";
    
    public static MovieRepository getInstance() {
        if (instance == null) {
            instance = new MovieRepository();
        }
        return instance;
    }

    public MutableLiveData<ArrayList<Movie>> getMovies() {
        setMovies();
        MutableLiveData<ArrayList<Movie>> moviesData = new MutableLiveData<>();
        moviesData.setValue(movies);
        return moviesData;
    }

    private void setMovies(){
        language = String.valueOf(R.string.language);
        ApiConfig api = new ApiConfig();
        api.createInstance().loadMovieData(API_KEY, language).enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                movies = new ArrayList<>(Arrays.asList(jsonResponse.getResults()));
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
