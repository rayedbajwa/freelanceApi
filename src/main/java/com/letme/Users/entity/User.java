package com.letme.Users.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Created by mbajwa11 on 12/22/16.
 */
@Table(name = "users_info")
@Entity
public class User{
    // An autogenerated id (unique for each user in the db)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "name")
    private String name;


    @Column(name ="age", nullable = true)
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // Public methods
    public User() { }

    public User(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String email, String name) {
        this.email = email;
        this.name = name;

    }

    public String toString(){
        return "\nUser Information: \n" +
                "\nName: " + this.name +
                "\nEmail: " + this.email +
                "\nAge: " + this.age   ;
    }

}
