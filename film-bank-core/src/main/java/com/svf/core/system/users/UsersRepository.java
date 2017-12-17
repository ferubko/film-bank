package com.svf.core.system.users;

import com.svf.core.system.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by stepanferubko
 */
@Repository
public class UsersRepository extends AbstractPropertiesRepository {
    private final static Logger LOG = Logger.getLogger(UsersRepository.class.getName());
    private static final String USERS_PROPERTIES = "users.properties";
    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    public List<User> findAll() {
        Properties users = load(USERS_PROPERTIES);
        Map<String, String[]> authorities = authoritiesRepository.findAll();
        return users.stringPropertyNames().stream()
                .map(login -> User.newUser(login, users.getProperty(login), authorities.get(login)))
                .collect(Collectors.toList());
    }

    public User remove(String login) {
        String[] authorities = authoritiesRepository.remove(login);
        Properties removed = remove(login, USERS_PROPERTIES);
        if (removed.isEmpty())
            return null;
        return User.newUser(login, removed.getProperty(login), authorities);
    }

    public User save(User user) {
        String login = user.getLogin();
        authoritiesRepository.save(login, user.getAuthorities());
        Set<User> data = new HashSet<>();
        data.addAll(findAll());
        if (data.contains(user)) {
            LOG.warning("There is no changes in user=" + login);
        } else {
            data.stream().filter(u -> u.getLogin().equals(login)).findFirst().ifPresent(u -> {
                LOG.info("Before: " + u);
                LOG.info("After : " + user);
            });
            boolean removed = data.removeIf(u -> u.getLogin().equals(login));
            LOG.warning("The user= " + login);
            data.add(user);
            saveAll(data);
        }
        return user;
    }

    private void saveAll(Collection<User> data) {
        Properties properties = new Properties();
        properties.putAll(data.stream().collect(Collectors.toMap(User::getLogin, User::getPassword)));
        write(properties, USERS_PROPERTIES);
    }

}
