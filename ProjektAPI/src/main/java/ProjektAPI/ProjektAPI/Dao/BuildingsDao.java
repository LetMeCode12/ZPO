package ProjektAPI.ProjektAPI.Dao;

import ProjektAPI.ProjektAPI.Entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingsDao extends JpaRepository<Building,Integer> {
}
