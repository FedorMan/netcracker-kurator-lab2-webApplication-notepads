package models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "saved_files")
public class SaveFile extends Essence{
    @Id
    @Column(name = "id")
    @GeneratedValue()
    private Integer id;
    @Column(name = "id_record")
    private int idRecord;
    @Column(name = "path_to_file")
    private String pathToFile;
    @Column(name = "time_create")
    private Timestamp timeCreate;
    @Column(name = "type")
    Type type;

    public SaveFile() {
    }

    public SaveFile(Integer idRecord, String pathToFile, Type type) {
        this.idRecord = idRecord;
        this.pathToFile = pathToFile;
        this.timeCreate = new Timestamp(System.currentTimeMillis());
        this.type=type;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(int idRecord) {
        this.idRecord = idRecord;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public Timestamp getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Timestamp timeCreate) {
        this.timeCreate = timeCreate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
