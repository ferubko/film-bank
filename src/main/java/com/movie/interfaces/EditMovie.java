package com.movie.interfaces;


import com.movie.entity.MovieEntity;

/**
 * Created by sferubko on 12.02.2017.
 */
public interface EditMovie {
    boolean save(MovieEntity movie);

    boolean edit(MovieEntity movie);

    boolean delete(MovieEntity movie);

    boolean add(MovieEntity movie);
}
