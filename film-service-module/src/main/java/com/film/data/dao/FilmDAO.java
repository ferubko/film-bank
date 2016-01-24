package com.film.data.dao;

import com.film.data.entity.Film;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Stepan on 1/10/2016.
 */

@Stateless
public class FilmDAO {
    @PersistenceContext
    private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Film> getUserData() {
        return em.createNamedQuery("allFilms").getResultList();
    }
}
