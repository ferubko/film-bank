package com.svf.core.repositories;

import com.svf.core.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Stepan Ferubko
 */
@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
}
