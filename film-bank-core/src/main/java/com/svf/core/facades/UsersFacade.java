package com.svf.core.facades;

import com.svf.core.system.users.UsersManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by stepanferubko
 */
@Service
public class UsersFacade {
    @Autowired
    private UsersManager usersManager;

}
