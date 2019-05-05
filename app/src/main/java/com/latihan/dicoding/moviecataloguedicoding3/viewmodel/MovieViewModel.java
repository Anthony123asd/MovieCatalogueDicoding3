package com.latihan.dicoding.moviecataloguedicoding3.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.latihan.dicoding.moviecataloguedicoding3.model.Movie;
import com.latihan.dicoding.moviecataloguedicoding3.repository.MovieRepository;

import java.util.ArrayList;

public class MovieViewModel extends ViewModel {

    private MovieRepository movieRepository;
    private static MutableLiveData<ArrayList<Movie>> movieData = null;

    public static LiveData<ArrayList<Movie>> getMoviesData() {
        return movieData;
    }

    public void init() {
        if (movieData == null) {
            movieRepository = MovieRepository.getInstance();
            movieData = movieRepository.getMovies();
        }
    }
}
