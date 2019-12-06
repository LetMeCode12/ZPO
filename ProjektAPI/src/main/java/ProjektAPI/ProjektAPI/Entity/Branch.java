package ProjektAPI.ProjektAPI.Entity;


import ProjektAPI.ProjektAPI.Dao.BuildingsDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="Branches")
public class Branch {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name="Nr_Branch")
    private int nr_Branch;
    @Column(name="Branch_Name")
    private String branch_Name;

    @OneToMany
    private List<Room> Rooms;

    public Branch(int nr_Branch, String branch_Name) {
        this.nr_Branch = nr_Branch;
        this.branch_Name = branch_Name;
        this.Rooms = new ArrayList<>();
    }

    public Branch() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getNr_Branch() {
        return nr_Branch;
    }

    public void setNr_Branch(int nr_Branch) {
        this.nr_Branch = nr_Branch;
    }

    public String getBranch_Name() {
        return branch_Name;
    }

    public void setBranch_Name(String branch_Name) {
        this.branch_Name = branch_Name;
    }

    public List<Room> getRooms() {
        return Rooms;
    }

    public void setRooms(List<Room> rooms) {
        Rooms = rooms;
    }
}
