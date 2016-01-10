package com.film.bank.server;

import com.film.bank.FilmBankServlet;
import com.film.bank.service.FilmDataService;
import com.vaadin.server.VaadinServlet;

/**
 * Created by Stepan on 1/10/2016.
 */
public class ServiceMediator {
    public static FilmDataService getAdminService() {
        return ((FilmBankServlet) VaadinServlet.getCurrent()).getUserDataService();
    }
}
