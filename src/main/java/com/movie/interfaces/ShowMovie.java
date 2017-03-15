package com.movie.interfaces;


import com.movie.entity.MovieEntity;

/**
 * Created by sferubko on 12.02.2017.
 */
public interface ShowMovie {
    void showMovie(MovieEntity movie);

    void downloadMovie(MovieEntity movie);
}
