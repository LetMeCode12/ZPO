package ProjektAPI.ProjektAPI.Entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="Patients")
public class Patients {

@Id
@GeneratedValue
private int id;

@Column(name="Name")
    private String name;
@Column(name="Surrname")
    private String surrname;
@Column(name = "Pesel")
    private long pesel;
@Column(name = "Date_of_birth")
    private Timestamp birth;

    public Patients() {
    }

    public Patients(String name, String surrname, long pesel, Timestamp birth) {
        this.name = name;
        this.surrname = surrname;
        this.pesel = pesel;
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurrname() {
        return surrname;
    }

    public void setSurrname(String surrname) {
        this.surrname = surrname;
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    public Timestamp getBirth() {
        return birth;
    }

    public void setBirth(Timestamp birth) {
        this.birth = birth;
    }
}
