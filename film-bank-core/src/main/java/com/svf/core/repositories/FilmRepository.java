package com.svf.core.repositories;

import com.svf.core.entity.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Stepan Ferubko
 */
@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {
}
