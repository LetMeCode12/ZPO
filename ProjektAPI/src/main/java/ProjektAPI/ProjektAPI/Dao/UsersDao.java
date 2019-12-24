package ProjektAPI.ProjektAPI.Dao;

import ProjektAPI.ProjektAPI.seciurity.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDao extends JpaRepository<User, Integer> {
}
