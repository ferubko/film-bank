package com.svf.core.system.users;

import com.svf.core.system.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by stepanferubko
 */
@Service
public class UsersService {
    private final ReadWriteLock usersLock = new ReentrantReadWriteLock();
    @Autowired
    private UsersRepository usersRepository;

    public User saveUser(User user) {
        Validate.notNull(user, "Null User can't be saved");
        validateUser(user);
        usersLock.writeLock().lock();
        try {
            return usersRepository.save(user);
        } finally {
            usersLock.writeLock().unlock();
        }
    }

    public User removeUser(String login) {
        String userId = StringUtils.trimToEmpty(login);
        Validate.notEmpty(userId, "Can't remove: invalid login");
        usersLock.writeLock().lock();
        try {
            return usersRepository.remove(login);
        } finally {
            usersLock.writeLock().unlock();
        }
    }

    public List<User> listUsers() {
        usersLock.readLock().lock();
        try {
            List<User> list = usersRepository.findAll();
            list.forEach(this::validateUser);
            return list;
        } finally {
            usersLock.readLock().unlock();
        }
    }

    private void validateUser(User v) {
        Validate.notEmpty(v.getLogin(), "User with empty or null login was provided");
        Validate.notEmpty(v.getPassword(), "User with empty password was provided: login=" + v.getLogin());
        Validate.notEmpty(v.getAuthorities(), "User without authorities was provided: login=" + v.getLogin());
    }
}
