package com.movie.beans;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by sferubko on 12.03.2017.
 */
@Component
public class TestBean {
    @Autowired
    private SessionFactory sessionFactory;

    public void test() {
        System.out.println("session Factory = " + sessionFactory);
    }
}
