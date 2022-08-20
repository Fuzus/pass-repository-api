package br.com.fuzusnoary.passrepositoryapi.dto;

import br.com.fuzusnoary.passrepositoryapi.entities.User;

public class UserDTO {
    private String name;
    private String email;
    private String token;
    private String password;

    public UserDTO(){}

    public UserDTO(User user) {
        name = user.getName();
        email = user.getEmail();
        token = user.getToken();
    }

    public UserDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
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
