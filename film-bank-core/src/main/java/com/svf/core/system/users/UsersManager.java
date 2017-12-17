package com.svf.core.system.users;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by stepanferubko
 */
//@Component
public class UsersManager {
    private final Lock usersLock;
    private UserDetailsManager userDetailsManager;


    public UsersManager(UserDetailsManager userDetailsManager) {
        this.userDetailsManager = userDetailsManager;
        this.usersLock = new ReentrantLock(true);
    }

    public void manageAll(List<com.svf.core.system.User> users) {
        usersLock.lock();
        try {
            users.forEach(this::setUser);
        } finally {
            usersLock.unlock();
        }
    }

    public void manage(com.svf.core.system.User user) {
        usersLock.lock();
        try {
            setUser(user);
        } finally {
            usersLock.unlock();
        }
    }

    public void deleteUser(String login) {
        usersLock.lock();
        try {
            if (userDetailsManager.userExists(login)) {
                userDetailsManager.deleteUser(login);
            }
        } finally {
            usersLock.unlock();
        }
    }

    private void setUser(com.svf.core.system.User user) {
        UserDetails userDetails = User.withUsername(user.getLogin())
                .password(user.getPassword())
                .authorities(user.getAuthorities())
                .build();
        if (userDetailsManager.userExists(userDetails.getUsername())) {
            userDetailsManager.updateUser(userDetails);
        } else {
            userDetailsManager.createUser(userDetails);
        }
    }

}
