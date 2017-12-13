package com.svf.core.cfg;

import org.hibernate.boot.model.naming.ImplicitNamingStrategy;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.model.source.spi.AttributePath;

import java.util.logging.Logger;

/**
 * Created by stepanferubko
 */
public class FilmBankImplicitNamingStrategy extends ImplicitNamingStrategyJpaCompliantImpl implements ImplicitNamingStrategy {
    private static Logger LOG = Logger.getLogger(FilmBankImplicitNamingStrategy.class.getName());

    @Override
    protected String transformAttributePath(AttributePath attributePath) {
        return attributePath.getFullPath();
    }
}
