package com.latihan.dicoding.moviecataloguedicoding3.ui.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.latihan.dicoding.moviecataloguedicoding3.R;
import com.latihan.dicoding.moviecataloguedicoding3.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    private ArrayList<Movie> movies;
    private Context context;

    public MovieAdapter(Fragment fragment, ArrayList<Movie> movies) {
        this.context = fragment.getContext();
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_movie, parent, false);
        return new MovieAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.movieTitle.setText(movies.get(i).getTitle());
        viewHolder.movieDate.setText(movies.get(i).getReleaseDate());
        viewHolder.movieDescription.setText(movies.get(i).getOverview());
        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w185"+ movies.get(i).getPosterPath())
                .apply(new RequestOptions().override(120, 155))
                .into(viewHolder.moviePoster);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies.clear();
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView movieTitle;
        TextView movieDate;
        TextView movieDescription;
        ImageView moviePoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.movie_title);
            movieDate = itemView.findViewById(R.id.movie_date);
            movieDescription = itemView.findViewById(R.id.movie_description);
            moviePoster = itemView.findViewById(R.id.movie_poster);
        }
    }


}
