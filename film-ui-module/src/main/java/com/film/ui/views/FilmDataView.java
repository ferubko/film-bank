package com.film.ui.views;

import com.film.data.entity.Film;
import com.film.ui.server.ServiceMediator;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by Stepan on 1/10/2016.
 */
public class FilmDataView extends CustomComponent {
    BeanItemContainer<Film> itemDS;

    public FilmDataView() {
        init();
    }

    private void init() {
        itemDS = new BeanItemContainer<>(Film.class);
        initData();
        Table table = new Table(null, itemDS);
        table.setImmediate(true);
        table.setSelectable(true);

        table.setVisibleColumns(new String[]{"firstName", "secondName"});
        table.setColumnHeaders(new String[]{"Name", "Second name"});
        table.setWidth(700, Unit.PIXELS);
        table.setHeight(300, Unit.PIXELS);
        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();
        content.addComponent(table);
        setCompositionRoot(content);
    }

    private void initData() {
        itemDS.addAll(ServiceMediator.getAdminService().getFilmsData());
        itemDS.sort(new String[]{"firstName"}, new boolean[]{false});
    }
}
