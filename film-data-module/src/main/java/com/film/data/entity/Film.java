package com.film.data.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Stepan on 1/10/2016.
 */
@Table(name = "film_data")
@Entity
@NamedQueries({
        @NamedQuery(name = "allFilms", query = "SELECT c from Film c")})
public class Film {
    @Id
    @GeneratedValue
    private long id;

    @Size(min = 1, max = 255)
    @Column(nullable = false, name = "first_name")
    private String firstName;
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, name = "second_name")
    private String secondName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        if (id != film.id) return false;
        if (!firstName.equals(film.firstName)) return false;
        return secondName.equals(film.secondName);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + firstName.hashCode();
        result = 31 * result + secondName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
