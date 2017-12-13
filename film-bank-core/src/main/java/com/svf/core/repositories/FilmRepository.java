package com.svf.core.repositories;

import com.svf.core.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by stepanferubko
 */
public interface FilmRepository extends JpaRepository<Film, Long>, JpaSpecificationExecutor<Film> {
//    List<Film> findByDate(String date);
}
