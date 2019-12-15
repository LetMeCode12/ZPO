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

    @Column(name = "ID_Patient")
    private UUID idPatient;

    public Bed(int nrBed, UUID idPatient) {
        this.nrBed = nrBed;
        this.idPatient = idPatient;
    }

    public Bed() {
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
