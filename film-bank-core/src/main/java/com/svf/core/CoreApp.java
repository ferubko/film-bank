package com.svf.core;

import com.svf.core.service.Application;
import com.svf.core.service.local.AppInitService;
import com.svf.core.tools.logger.AppLogger;
import com.svf.core.tools.logger.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Created by stepanferubko
 */
@SpringBootApplication
public class CoreApp {
    private final static Logger LOG = AppLogger.getLogger(CoreApp.class);

    public static void main(String[] args) {
        System.out.printf("hello");
//        SpringApplication.run(CoreApp.class);
//        Application
//                .application(logger)
//                .withStartFunc(a -> SpringApplication.run(CoreApp.class, a))
//                .withPostStartFunc(ctx -> ctx.getBean(AppInitService.class).initData())
//                .go(args);
    }
}
