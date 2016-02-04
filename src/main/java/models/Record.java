package models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="recording")
public class Record extends Essence{
    @Id
    @Column(name = "id")
    @GeneratedValue()
    Integer id;
    @Column(name = "id_notepad")
    Integer idNotepad;
    @Column(name = "name")
    String name;
    @Column(name = "text")
    String text;
    @Column(name = "time_create")
    Timestamp timeCreate;

    public Record(String name,String text,Integer idNotepad) {
        this.idNotepad=idNotepad;
        this.text=text;
        this.name = name;
        this.timeCreate = new Timestamp(System.currentTimeMillis());
    }

    public Record() {
        this.timeCreate=new Timestamp(System.currentTimeMillis());
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdNotepad() {
        return idNotepad;
    }

    public void setIdNotepad(Integer idNotepad) {
        this.idNotepad = idNotepad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Timestamp timeCreate) {
        this.timeCreate = timeCreate;
    }
}
