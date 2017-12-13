package com.svf.core.entity;

/**
 * Created by stepanferubko
 */
//@Entity
public class Director {
    //    @Id
//    @GeneratedValue
    private Long id;
    //    @Column(nullable = false)
    private String firstName;
    //    @Column(nullable = false)
    private String secondName;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Director director = (Director) o;

        if (id != null ? !id.equals(director.id) : director.id != null) return false;
        if (firstName != null ? !firstName.equals(director.firstName) : director.firstName != null) return false;
        return secondName != null ? secondName.equals(director.secondName) : director.secondName == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
