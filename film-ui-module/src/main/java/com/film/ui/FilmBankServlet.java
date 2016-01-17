package com.film.ui;

import com.film.data.service.FilmDataService;
import com.vaadin.server.VaadinServlet;

import javax.ejb.EJB;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Created by Stepan on 1/10/2016.
 */
@WebServlet(name = "FilmBankServlet", urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "UI", value = "com.film.ui.FilmBankUI")
        })
public class FilmBankServlet extends VaadinServlet {
    @EJB
    private FilmDataService filmDataService;

    public FilmDataService getFilmDataService() {
        return filmDataService;
    }
}
