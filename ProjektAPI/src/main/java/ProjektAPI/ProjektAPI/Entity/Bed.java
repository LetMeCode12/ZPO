package ProjektAPI.ProjektAPI.Entity;


import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="Beds")
public class Bed {

    @Id
    @GeneratedValue
    private UUID idBed;

    @Column(name="Nr_Bed")
    private int nrBed;

    private UUID RoomID;

    @Column(name = "ID_Patient")
    private UUID idPatient;

    public Bed(int nrBed, UUID idPatient,UUID RoomID) {
        this.nrBed = nrBed;
        this.idPatient = idPatient;
        this.RoomID= RoomID;
    }

    public Bed() {
    }

    public UUID getRoomID() {
        return RoomID;
    }

    public void setRoomID(UUID roomID) {
        RoomID = roomID;
    }

    public UUID getIdBed() {
        return idBed;
    }

    public void setIdBed(UUID idBed) {
        this.idBed = idBed;
    }

    public int getNrBed() {
        return nrBed;
    }

    public void setNrBed(int nrBed) {
        this.nrBed = nrBed;
    }

    public UUID getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(UUID idPatient) {
        this.idPatient = idPatient;
    }
}
