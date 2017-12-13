package com.svf.core.cfg;

import com.svf.core.service.validation.EntityValidatorBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.validation.Validator;

/**
 * Created by stepanferubko
 */
@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = PersistenceConfig.ENTITIES_PKG)
public class PersistenceConfig {
    public static final String ENTITIES_PKG = "com.svf.core.entity";

    @Bean
    public EntityValidatorBean entityValidator(Validator validator) {
        return new EntityValidatorBean(validator);
    }
}
