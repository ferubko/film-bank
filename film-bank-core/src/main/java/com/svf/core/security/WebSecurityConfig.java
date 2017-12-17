package com.svf.core.security;

import com.svf.core.system.users.UsersManager;
import com.svf.core.system.users.UsersService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

/**
 * Created by stepanferubko
 */
@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager();
    }

    @Bean
    public UsersManager authenticationBuilder(UserDetailsService userDetailsService, UsersService usersService) {
        if (userDetailsService instanceof UserDetailsManager) {
            UsersManager authenticationBuilder = new UsersManager((UserDetailsManager) userDetailsService);
            authenticationBuilder.manageAll(usersService.listUsers());
            return authenticationBuilder;
        }
        throw new UnsupportedOperationException("UserDetailsService is not supported: type=" + userDetailsService.getClass().getName());
    }
}
