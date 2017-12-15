package com.svf.core.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by stepanferubko
 */
@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Column(nullable = false)
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date releaseDate;
//    @ManyToOne(targetEntity = Director.class)
//    @JoinColumn(nullable = false)
//    private Director director;
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"))
//    private Set<Actor> actors;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "film_actor",
//            joinColumns = { @JoinColumn(name = "film_id") },
//            inverseJoinColumns = { @JoinColumn(name = "actor_id") })
//    private Set<Actor> actors = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

//    public Director getDirector() {
//        return director;
//    }
//
//    public void setDirector(Director director) {
//        this.director = director;
//    }


}
