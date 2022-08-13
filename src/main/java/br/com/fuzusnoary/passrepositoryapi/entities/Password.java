package br.com.fuzusnoary.passrepositoryapi.entities;


import br.com.fuzusnoary.passrepositoryapi.entities.enums.PassType;

import javax.persistence.*;

@Entity
@Table(name = "tb_password")
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(value = EnumType.ORDINAL)
    private PassType passType;
    private String password;

    @ManyToOne
    @JoinColumn(name = "user_token")
    private User user;

    public Password() {
    }

    public Password(Long id, String name, int passType, String password) {
        this.id = id;
        this.name = name;
        setPassType(PassType.valueOf(passType));
        this.password = password;
    }

    public Password(Long id, String name, int passType, String password, User user) {
        this.id = id;
        this.name = name;
        setPassType(PassType.valueOf(passType));
        this.password = password;
        this.user = user;
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

    public int getPassType() {
        return passType.ordinal();
    }

    public void setPassType(PassType passType) {
        this.passType = passType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
