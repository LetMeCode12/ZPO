package ProjektAPI.ProjektAPI.Dao;

import ProjektAPI.ProjektAPI.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorDao extends JpaRepository<Doctor,Integer> {
}
