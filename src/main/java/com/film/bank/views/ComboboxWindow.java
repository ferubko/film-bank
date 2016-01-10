package com.film.bank.views;

import com.vaadin.shared.ui.combobox.FilteringMode;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by Stepan on 1/10/2016.
 */
public class ComboboxWindow extends Window {

    public ComboboxWindow() {
        init();
        setSizeFull();
        setClosable(false);
        setResizable(false);
    }

    private void init() {
        ComboBox comboBox = new ComboBox();
        comboBox.setWidth(400, Unit.PIXELS);
        Map<String, String> loadMapping = loadMapping();
        loadMapping.forEach((k, v) -> {
            comboBox.addItem(k);
            comboBox.getItemCaption(v);
        });
        comboBox.setImmediate(true);
        comboBox.setFilteringMode(FilteringMode.CONTAINS);
        comboBox.setPageLength(loadMapping.size());
        FilmDataView userView = new FilmDataView();

        VerticalLayout layout = new VerticalLayout();
        layout.addComponents(comboBox, userView);
        layout.setSpacing(true);

        setContent(layout);
    }

    private Map<String, String> loadMapping() {
        String sourceFile = "/com.film.bank/Skill_EN.csv";
        String defaultFile = "/com.film.bank/Skill_EN.csv";

        try (InputStream resourceAsStream = getStream(sourceFile, defaultFile)) {
            List<String> list = IOUtils.readLines(resourceAsStream, "UTF-8");

            return list.stream()
                    .map(s -> s.split(";"))
                    .filter(s -> s.length == 2)
                    .filter(s -> !s[0].equals("code"))

                    .collect(Collectors.toMap((s -> s[0]), (s -> s[1].replaceAll(" +", " ").trim()),
                            (u, v) -> {
                                throw new IllegalStateException(String.format("Duplicate key %s", u));
                            }, LinkedHashMap::new));
        } catch (IOException e) {
            Logger.getLogger("Data loading error: " + sourceFile + "/" + defaultFile);
        }
        return Collections.emptyMap();
    }

    private InputStream getStream(String sourceFile, String defaultFile) {
        InputStream resourceAsStream = getClass().getResourceAsStream(sourceFile);
        if (resourceAsStream == null) {
            resourceAsStream = getClass().getResourceAsStream(defaultFile);
        }
        return resourceAsStream;
    }
}
