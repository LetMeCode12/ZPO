package ProjektAPI.ProjektAPI.Dao;

import ProjektAPI.ProjektAPI.Entity.Bed;
import ProjektAPI.ProjektAPI.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BedDao  extends JpaRepository<Bed,Integer> {
}
