package ProjektAPI.ProjektAPI.RestControllers;


import ProjektAPI.ProjektAPI.Dao.UsersDao;
import ProjektAPI.ProjektAPI.seciurity.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/Users")
@RestController
public class UsersRest {

    @Autowired
    UsersDao usersDao;

    @PostMapping("/signIn")
    private void createUser(@RequestBody User user){
        usersDao.save(new User(user.getLogin(),user.getPassword(),user.isAdmin()));
    }

    @GetMapping("/getUsr")
    private List<User> getUsr(){
        return usersDao.findAll();
    }

    @DeleteMapping("/delUsr/{idUser}")
    private void delete(@PathVariable UUID idUser){
        usersDao.delete(usersDao.findAll().stream().parallel().filter(e->e.getIdUser().equals(idUser)).findFirst().orElse(null));
    }

}
