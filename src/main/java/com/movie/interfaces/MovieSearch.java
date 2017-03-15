package com.movie.interfaces;


import com.movie.entity.DirectorEntity;
import com.movie.entity.GenreEntity;
import com.movie.entity.MovieEntity;

import java.util.List;

/**
 * Created by sferubko on 12.02.2017.
 */
public interface MovieSearch {
    List<MovieEntity> getMovies();

    List<MovieEntity> getMovies(DirectorEntity director);

    List<MovieEntity> getMovies(String movieName);

    List<MovieEntity> getMovies(GenreEntity genre);

    List<MovieEntity> getMovies(Integer rate);
}
