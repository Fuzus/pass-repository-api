package br.com.fuzusnoary.passrepositoryapi.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {

    private String name;
    @Column(unique = true)
    private String email;
    @Id
    private String token;


    public User(){}

    public User(String name, String email, String token) {
        this.name = name;
        this.email = email;
        this.token = token;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }



    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }
}
