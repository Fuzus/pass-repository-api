package br.com.fuzusnoary.passrepositoryapi.dto;

import br.com.fuzusnoary.passrepositoryapi.entities.User;

public class UserReturnableDTO {

    private Long id;
    private String name;
    private String email;
    private String token;

    public UserReturnableDTO() {
    }

    public UserReturnableDTO(Long id, String name, String email, String token) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.token = token;
    }

    public UserReturnableDTO(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
        this.token = userDTO.getToken();
    }

    public UserReturnableDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.token = user.getToken();
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
