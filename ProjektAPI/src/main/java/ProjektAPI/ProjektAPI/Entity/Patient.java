package ProjektAPI.ProjektAPI.Entity;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name="Patients")
public class Patient {

@Id
@GeneratedValue
private UUID id;

@Column(name="Name")
    private String name;
@Column(name="Surrname")
    private String surrname;
@Column(name = "Pesel")
    private Integer pesel;
@Column(name = "Date_of_birth")
    private Timestamp birth;
@Column(name="Address")
    private String address;
@Column(name = "Date_of_Admission")
    private Timestamp dateOfAdmission;
@Column(name = "DoctorID")
    private UUID DoctorID;
@Column(name = "BedID")
    private UUID bedID;
    public Patient() {
    }

    public Patient(String name, String surrname, Integer pesel, Timestamp birth, String address, UUID DoctorID,UUID bedID) {
        this.name = name;
        this.surrname = surrname;
        this.pesel = pesel;
        this.birth = birth;
        this.address=address;
        this.dateOfAdmission = new Timestamp(System.currentTimeMillis());
        this.DoctorID = DoctorID;
        this.bedID = bedID;
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

    public Integer getPesel() {
        return pesel;
    }

    public void setPesel(Integer pesel) {
        this.pesel = pesel;
    }

    public Timestamp getBirth() {
        return birth;
    }

    public void setBirth(Timestamp birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(Timestamp dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public UUID getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(UUID doctorID) {
        DoctorID = doctorID;
    }

    public UUID getBedID() {
        return bedID;
    }

    public void setBedID(UUID bedID) {
        this.bedID = bedID;
    }
}
