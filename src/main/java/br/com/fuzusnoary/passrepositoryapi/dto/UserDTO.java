package br.com.fuzusnoary.passrepositoryapi.dto;

import br.com.fuzusnoary.passrepositoryapi.entities.User;

public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String token;
    private String password;

    public UserDTO(){}

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        token = user.getToken();
    }

    public UserDTO(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }


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

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
