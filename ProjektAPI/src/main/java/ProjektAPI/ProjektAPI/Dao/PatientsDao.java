package ProjektAPI.ProjektAPI.Dao;

import ProjektAPI.ProjektAPI.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientsDao extends JpaRepository<Patient,Integer> {
}
