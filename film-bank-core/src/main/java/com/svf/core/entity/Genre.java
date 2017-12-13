package com.svf.core.entity;

import com.svf.core.entity.enums.GenreType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by stepanferubko
 */
//@Entity
public class Genre {
//    @Id
//    @GeneratedValue
    private Long id;
//    @NotNull
//    @Enumerated(EnumType.STRING)
    public GenreType genreType;

    public Genre() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GenreType getGenreType() {
        return genreType;
    }

    public void setGenreType(GenreType genreType) {
        this.genreType = genreType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        if (id != null ? !id.equals(genre.id) : genre.id != null) return false;
        return genreType == genre.genreType;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (genreType != null ? genreType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", genreType=" + genreType +
                '}';
    }
}
