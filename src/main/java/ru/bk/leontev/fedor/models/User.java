package ru.bk.leontev.fedor.models;


import javax.persistence.*;
import java.sql.Timestamp;


@javax.persistence.Entity
@Table(name = "users")
public class User implements Entity {
    @Id
    @Column(name = "id")
    @GeneratedValue()
    private Integer id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "time_create")
    private Timestamp timeCreate;

    public User() {
        this.timeCreate = new Timestamp(System.currentTimeMillis());
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.timeCreate = new Timestamp(System.currentTimeMillis());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Timestamp timeCreate) {
        this.timeCreate = timeCreate;
    }

    @Override
    public String toString(){
        return getLogin()+"\t"+getPassword()+"\t"+ getTimeCreate().toString();
    }
}
