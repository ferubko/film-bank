package com.svf.core.facades;

import com.svf.core.system.Roles;
import com.svf.core.system.User;
import com.svf.core.system.users.UsersManager;
import com.svf.core.system.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by stepanferubko
 */
@Service
public class UsersFacade {
    private final static Logger LOG = Logger.getLogger(UsersFacade.class.getName());

    @Autowired
    private UsersManager usersManager;
    @Autowired
    private UsersService usersService;

    public void saveUser(User user) {
        String login = user.getLogin();
        LOG.info("Save new user name= " + login);
        User savedUser = usersService.saveUser(user);
        LOG.info("Manage new user name= " + login);
        usersManager.manage(savedUser);
    }

    public void removeUser(String login) {
        LOG.info("Remove user from storage name= " + login);

        User removed = usersService.removeUser(login);
        if (removed == null) {
            LOG.info("There is no user registered in the storage with login={} try to remove authentications " + login);
            usersManager.deleteUser(login);
        } else {
            String removedLogin = removed.getLogin();
            LOG.info("User has been removed login={} try to remove authentications " + removedLogin);
            usersManager.deleteUser(removedLogin);
        }
    }

    public List<String> getAllAuthorities() {
        return Arrays.asList(Roles.ALL);
    }

    public List<User> listAllUsers() {
        List<User> users = usersService.listUsers();
        return users.stream()
                .peek(u -> u.setPassword(null))
                .collect(Collectors.toList());
    }

}
