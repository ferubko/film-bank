package com.svf.core.cfg;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by stepanferubko
 */
public class FilmBankPhysicalNamingStrategy extends SpringPhysicalNamingStrategy implements PhysicalNamingStrategy {
    private static Logger LOG = Logger.getLogger(FilmBankPhysicalNamingStrategy.class.getName());

    private static final String TABLE_PREFIX_PROPERTY = "table_prefix";

    private final Properties prefixes;

    public FilmBankPhysicalNamingStrategy() {
        this.prefixes = new Properties();
        loadPrefixes();
    }

    private void loadPrefixes() {
        try (InputStream prefixesIS = getClass().getResourceAsStream("/db_embedded_property_prefixes.properties")) {
            prefixes.load(prefixesIS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        if (name.isQuoted()) {
            LOG.info("Table name is quoted: ");
            return name;
        }
        if (name.getText().equals("hibernate_sequences")) {
            return name;
        }

        String prefix = prefixes.getProperty(TABLE_PREFIX_PROPERTY, "");
        Identifier middleName = super.toPhysicalTableName(name, jdbcEnvironment);

        return jdbcEnvironment.getIdentifierHelper().toIdentifier(
                (prefix + middleName),
                middleName.isQuoted()
        );
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        String propertyName = name.getText();
        if (name.isQuoted() && !"claimProcessInstance_id".equals(name.getText())) {
            LOG.info("Column name is quoted: {}");
            return name;
        }
        StringBuilder value = new StringBuilder();
        String[] properties = propertyName.split("\\.");
        if (properties.length > 1) {
            for (int i = 0; i < properties.length - 1; i++) {
                String res = prefixes.getProperty(properties[i], super.toPhysicalColumnName(new Identifier(properties[i], name.isQuoted()), jdbcEnvironment).getText());
                value.append(res).append("_");
            }
        }
        value.append(super.toPhysicalColumnName(new Identifier(properties[properties.length - 1], name.isQuoted()), jdbcEnvironment).getText());
        return new Identifier(value.toString(), name.isQuoted());
    }

    private Identifier printResult(Identifier src, Identifier res) {
        LOG.info("Source: {} Result: {}");
        return res;
    }
}
