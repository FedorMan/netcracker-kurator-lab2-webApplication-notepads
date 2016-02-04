package models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "notepads")
public class Notepad extends Essence{
    @Id
    @Column(name = "id")
    @GeneratedValue()
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "time_create")
    private Timestamp timeCreate;
    @Column(name = "id_user")
    private Integer id_user;

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Notepad(String name,Integer id_user) {
        this.id_user=id_user;
        this.name = name;
        this.timeCreate = new Timestamp(System.currentTimeMillis());
    }

    public Notepad() {
        this.timeCreate=new Timestamp(System.currentTimeMillis());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Timestamp timeCreate) {
        this.timeCreate = timeCreate;
    }
}
