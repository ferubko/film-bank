package com.svf.core.service;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by stepanferubko
 */
public class Application {
    private final Logger log;
    private Function<String[], ConfigurableApplicationContext> startFunc;
    private Function<ConfigurableApplicationContext, Boolean> postStartAction;
    private Runnable stopAction;

    private Application(Logger log) {
        this.log = log;
        this.postStartAction = c -> c != null;
    }

    public static Application application(Logger log) {
        return new Application(log)
                .withPostStartFunc(c -> c != null)
                .withStopAction(() -> System.exit(0));
    }

    public Application withStartFunc(Function<String[], ConfigurableApplicationContext> startFunc) {
        this.startFunc = startFunc;
        return this;
    }

    public Application withPostStartFunc(Function<ConfigurableApplicationContext, Boolean> postStartAction) {
        if (this.postStartAction != null) {
            List<Function<ConfigurableApplicationContext, Boolean>> actions = Arrays.asList(this.postStartAction, postStartAction);
            this.postStartAction = ctx -> {
                Optional<Boolean> first = actions.stream().map(a -> a.apply(ctx)).filter(r -> !r).findFirst();
                return !first.isPresent();
            };
        } else {
            this.postStartAction = postStartAction;
        }
        return this;
    }

    public Application withStopAction(Runnable stopAction) {
        this.stopAction = stopAction;
        return this;
    }

    public void go(String[] args) {
        try {
            log.info("Initialise application...");
            ConfigurableApplicationContext context = startFunc.apply(args);

            log.info("Apply post-start functions...");
            Boolean res = postStartAction.apply(context);

            log.info("Post-start functions were finished");
            if (res) {
                ConfigurableEnvironment env = context.getEnvironment();
                log.info("Module is ready for using:");
            } else {
                log.severe("Some post-start action was not successful: application will be stopped");
                stopAction.run();
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "Service initialisation error", e);
            stopAction.run();
        }
    }
}
