package br.com.fuzusnoary.passrepositoryapi.entities;

import org.springframework.security.core.token.Sha512DigestUtils;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String token;

    public User(){}

    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        createToken(shuffle(email, password));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    private void createToken(String str) {
        this.token =  Sha512DigestUtils.shaHex(str);
    }

    private String shuffle(String email, String password) {
        StringBuilder result = new StringBuilder();
        int emailIndex = 0;
        for (int i = 0; i < password.length(); i++) {
            result.append(password.charAt(i));
            result.append(email.charAt(emailIndex));
            emailIndex++;
            if (emailIndex == email.length()) {
                emailIndex = 0;
            }
        }
        return result.toString();
    }
}
