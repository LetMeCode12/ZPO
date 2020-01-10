package ProjektAPI.ProjektAPI.Entity;


import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="Rooms")
public class Room {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name="Nr_Room")
    private Integer nr_Room;

    private UUID BranchID;

//    @Column(name = "Free_Beds")
//    private Integer free_Beds;

    @OneToMany
    private List<Bed> Beds;

    public Room(Integer nr_Room,UUID BranchID) {
        this.nr_Room = nr_Room;
       // this.free_Beds = free_Beds;
        this.Beds = new ArrayList<>();
        this.BranchID=BranchID;
    }

    public UUID getBranchID() {
        return BranchID;
    }

    public void setBranchID(UUID branchID) {
        BranchID = branchID;
    }

    public Room() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getNr_Room() {
        return nr_Room;
    }

    public void setNr_Room(Integer nr_Room) {
        this.nr_Room = nr_Room;
    }

    public List<Bed> getBeds() {
        return Beds;
    }

    public void setBeds(List<Bed> beds) {
        Beds = beds;
    }
    //    public Integer getFree_Beds() {
//        return free_Beds;
//    }
//
//    public void setFree_Beds(Integer free_Beds) {
//        this.free_Beds = free_Beds;
//    }

//    public Integer getBeds() {
//        return Beds;
//    }
//
//    public void setBeds(Integer beds) {
//        this.Beds = beds;
//    }
}
