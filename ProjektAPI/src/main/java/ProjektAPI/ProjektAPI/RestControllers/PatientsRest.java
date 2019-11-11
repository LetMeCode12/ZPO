package ProjektAPI.ProjektAPI.RestControllers;


import ProjektAPI.ProjektAPI.Dao.PatientsDao;
import ProjektAPI.ProjektAPI.Entity.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RequestMapping("/Patients")
@RestController
public class PatientsRest {

    @Autowired
    PatientsDao patientsDao;

    @GetMapping("/getAll")
    private List<Patients> getAll (){
        return patientsDao.findAll();
    }

    @GetMapping("/getByName/{name}/{surrname}")
    private Patients getByNameSurrname(@PathVariable String name,@PathVariable String surrname){
        return patientsDao.findAll().stream()
                .filter(n->n.getName().equals(name))
                .filter(s->s.getSurrname().equals(surrname))
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/addPatient")
    private void addPatient(@RequestBody Patients patients){
        patientsDao.save(new Patients(patients.getName(),patients.getSurrname(),patients.getPesel(),patients.getBirth()));
    }
}
