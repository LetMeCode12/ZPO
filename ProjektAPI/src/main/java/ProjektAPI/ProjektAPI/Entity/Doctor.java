package ProjektAPI.ProjektAPI.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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
    @Column(name="Branch")
    private UUID branchID;


    @Column(name="Patients")
    @ManyToMany
    private List<Patient> patients;

    public Doctor(String name, String surrname, String specialization, UUID branchID) {
        this.name = name;
        this.surrname = surrname;
        this.specialization = specialization;
        this.branchID=branchID;
        this.patients=new ArrayList<>();
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

    public UUID getBranchID() {
        return branchID;
    }

    public void setBranchID(UUID branchID) {
        this.branchID = branchID;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        patients = patients;
    }
}
