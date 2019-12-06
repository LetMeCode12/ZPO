package ProjektAPI.ProjektAPI.Entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="Doctors")
public class Doctor {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name="Name")
    private String name;
    @Column(name="Surrname")
    private String surrname;
    @Column(name="Specialization")
    private String specialization;

    public Doctor(String name, String surrname, String specialization) {
        this.name = name;
        this.surrname = surrname;
        this.specialization = specialization;
    }

    public Doctor() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
