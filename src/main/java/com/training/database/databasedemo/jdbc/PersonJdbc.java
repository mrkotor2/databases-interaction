package com.training.database.databasedemo.jdbc;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
//@Entity
public class PersonJdbc {

    //    @Id
//    @GeneratedValue
    private int id;

    private String name;
    private String location;
    private Date birthDate;

    public PersonJdbc() {

    }

    public PersonJdbc(int id, String name, String location, Date birthDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
