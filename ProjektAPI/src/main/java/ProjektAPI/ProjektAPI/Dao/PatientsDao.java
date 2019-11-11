package ProjektAPI.ProjektAPI.Dao;

import ProjektAPI.ProjektAPI.Entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientsDao extends JpaRepository<Patients,Integer> {
}
