package com.svf.core.system;

import javax.jws.soap.SOAPBinding;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by stepanferubko
 */
public class User implements Serializable {
    private String login;
    private String password;
    private String[] authorities;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String[] authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(authorities, user.authorities);

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(authorities);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + Arrays.toString(authorities) +
                '}';
    }
    public static User newUser(String login,String password, String[] auth){
        User user=new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setAuthorities(auth);
        return user;
    }
}
