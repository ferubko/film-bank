package com.film.ui.views;

import com.vaadin.ui.*;

/**
 * Created by Stepan on 1/10/2016.
 */
public class AddUserModalWindow extends Window {
    private UserHandler handler;

    public AddUserModalWindow() {
        super("Add new user");
        setClosable(true);
        setWidth(400, Unit.PIXELS);
        setHeight(300, Unit.PIXELS);
        initContent();
    }

    private void initContent() {
        TextField userName = new TextField("User Name");
        TextField userSecondName = new TextField("Second Name");
        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();
        Button addButton = new Button("Add", e -> {
            handler.addUser();
        });
        content.addComponents(userName, userSecondName, addButton);
        content.setComponentAlignment(addButton, Alignment.BOTTOM_RIGHT);
    }

    public void setHandler(UserHandler handler) {
        this.handler = handler;
    }

    public interface UserHandler {
        //        public addUser(PersonalUserData userData)
        public void addUser();
    }
}
