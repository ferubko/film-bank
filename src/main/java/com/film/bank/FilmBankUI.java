package com.film.bank;

import com.film.bank.views.ComboboxWindow;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * Created by Stepan on 1/10/2016.
 */
@SuppressWarnings({"serial", "unchecked"})
@Title("Film")
@Theme("film_bank")
public class FilmBankUI extends UI {
    @Override
    protected void init(VaadinRequest request) {
        ComboboxWindow components = new ComboboxWindow();
        addWindow(components);
    }
}
