package com.film.ui.server;

import com.film.data.service.FilmDataService;
import com.film.ui.FilmBankServlet;
import com.vaadin.server.VaadinServlet;

/**
 * Created by Stepan on 1/10/2016.
 */
public class ServiceMediator {
    public static FilmDataService getAdminService() {
        return ((FilmBankServlet) VaadinServlet.getCurrent()).getFilmDataService();
    }
}
