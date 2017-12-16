package com.svf.core.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by stepanferubko
 */
@Entity
public class Actor {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String secondName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actor actor = (Actor) o;

        if (id != null ? !id.equals(actor.id) : actor.id != null) return false;
        if (firstName != null ? !firstName.equals(actor.firstName) : actor.firstName != null) return false;
        if (secondName != null ? !secondName.equals(actor.secondName) : actor.secondName != null) return false;
        return birthday != null ? birthday.equals(actor.birthday) : actor.birthday == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
