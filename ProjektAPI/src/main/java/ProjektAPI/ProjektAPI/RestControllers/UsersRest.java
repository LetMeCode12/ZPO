package ProjektAPI.ProjektAPI.RestControllers;


import ProjektAPI.ProjektAPI.Dao.UsersDao;
import ProjektAPI.ProjektAPI.seciurity.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Users")
@RestController
public class UsersRest {

    @Autowired
    UsersDao usersDao;

    @PostMapping("/signIn")
    private void createUser(@RequestBody User user){
        usersDao.save(new User(user.getLogin(),user.getPassword(),user.isAdmin()));
    }

}
