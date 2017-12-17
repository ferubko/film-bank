package com.svf.core.controller;

import com.svf.core.facades.UsersFacade;
import com.svf.core.integration.AbstractResponse;
import com.svf.core.integration.ObjectsResponse;
import com.svf.core.system.Roles;
import com.svf.core.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by stepanferubko
 */
@RestController
@RequestMapping("/api/users")
public class UserController extends AbstractController {
    private final static Logger LOG = Logger.getLogger(UserController.class.getName());
    @Autowired
    private UsersFacade usersFacade;

    @RequestMapping(path = "/current/roles", method = RequestMethod.POST)
    public List<String> getAuthorities(Authentication authentication) {
        if (authentication.isAuthenticated()) {
            return authentication
                    .getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Secured(Roles.MODERATOR)
    @RequestMapping(method = RequestMethod.POST)
    public AbstractResponse saveUser(@RequestBody User user) {
        return catchBusinessMethodException(
                new AbstractResponse(),
                (resp) -> {
                    usersFacade.saveUser(user);
                    return resp;
                },
                (th) -> LOG.severe(th.getMessage())
        );
    }

    @Secured(Roles.MODERATOR)
    @RequestMapping(path = "{login}", method = RequestMethod.DELETE)
    public AbstractResponse removeUser(@PathVariable("login") String login) {
        return catchBusinessMethodException(
                new AbstractResponse(),
                (resp) -> {
                    usersFacade.removeUser(login);
                    return resp;
                },
                (th) -> LOG.severe(th.getMessage())
        );
    }

    @Secured(Roles.MODERATOR)
    @RequestMapping(path = "/roles", method = RequestMethod.GET)
    public ObjectsResponse<String> getAllAuthorities() {
        return catchBusinessMethodException(
                new ObjectsResponse<>(),
                (resp) -> {
                    resp.setValues(usersFacade.getAllAuthorities());
                    return resp;
                },
                (th) -> LOG.severe("Unexpected error " + th.getMessage())
        );
    }

    @Secured(Roles.MODERATOR)
    @RequestMapping(method = RequestMethod.GET)
    public ObjectsResponse<User> getAllUsers() {
        return catchBusinessMethodException(
                new ObjectsResponse<>(),
                (resp) -> {
                    resp.setValues(usersFacade.listAllUsers());
                    return resp;
                },
                (th) -> LOG.severe("Unexpected error " + th.getMessage())
        );
    }
}
