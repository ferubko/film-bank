package com.svf.core.repositories;

import com.svf.core.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by stepanferubko
 */
public interface ActorRepository extends JpaRepository<Actor, Long> {
}
