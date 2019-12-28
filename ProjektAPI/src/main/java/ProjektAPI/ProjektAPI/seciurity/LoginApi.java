package ProjektAPI.ProjektAPI.seciurity;

import ProjektAPI.ProjektAPI.Dao.UsersDao;
import ProjektAPI.ProjektAPI.seciurity.Entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginApi {

    @Autowired
    UsersDao usersDao;
    @CrossOrigin
    @PostMapping("/logIn")
    public String login(@RequestBody User user){
        User login = usersDao.findAll().stream().parallel().filter(e->e.getLogin().equals(user.getLogin())).filter(r->r.getPassword().equals(user.getPassword())).findFirst().orElse(null);

        if(login!=null) {

            long Time = System.currentTimeMillis();
            long endTime = Time + 60000;

            return Jwts.builder()
                    .setSubject(user.getLogin())
                    .claim("roles", "user")
                    .setIssuedAt(new Date(Time))
                    .setExpiration(new Date(endTime))
                    .signWith(SignatureAlgorithm.HS512, "LoremIpsum")
                    .compact()+(login.isAdmin()?"ADMIN":"_____");
        }
        return "";
    }

}
