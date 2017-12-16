package com.svf.core.repositories;

import com.svf.core.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by stepanferubko
 */
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
