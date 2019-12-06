package ProjektAPI.ProjektAPI.Entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="Buildings")
public class Building {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name="Nr_Building")
        private Integer nr_Budynku;

    @Column(name="Address")
        private String address;

    @ManyToMany//(mappedBy = "building")
        private List<Branch> branches ;


    public Building(Integer nr_Budynku, String address) {
        this.nr_Budynku = nr_Budynku;
        this.address = address;
        this.branches=new ArrayList<>();
    }

    public Building() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getNr_Budynku() {
        return nr_Budynku;
    }

    public void setNr_Budynku(Integer nr_Budynku) {
        this.nr_Budynku = nr_Budynku;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }
}
