package com.film.ui;

import com.film.ui.views.FilmDataView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * Created by Stepan on 1/10/2016.
 */
@SuppressWarnings({"serial", "unchecked"})
@Title(value = "Film")
@Theme("film-bank")
public class FilmBankUI extends UI {
    @Override
    protected void init(VaadinRequest request) {
        FilmDataView filmDataView = new FilmDataView();
        setContent(filmDataView);
    }
}