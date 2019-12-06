package ProjektAPI.ProjektAPI.Dao;

import ProjektAPI.ProjektAPI.Entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchDao extends JpaRepository<Branch,Integer> {
}
