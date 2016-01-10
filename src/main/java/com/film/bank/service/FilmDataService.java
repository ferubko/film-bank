package com.film.bank.service;

import com.film.bank.dao.FilmDAO;
import com.film.bank.entity.Film;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by Stepan on 1/10/2016.
 */
@Stateless
public class FilmDataService {
    @EJB
    private FilmDAO filmDAO;

    @PermitAll
    public List<Film> getFilmsData() {
        return filmDAO.getUserData();
    }
}
