package ProjektAPI.ProjektAPI.RestControllers;


import ProjektAPI.ProjektAPI.Dao.PatientsDao;
import ProjektAPI.ProjektAPI.Entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RequestMapping("/Patients")
@RestController
public class PatientsRest {

    @Autowired
    PatientsDao patientsDao;

    @GetMapping("/getAll")
    private List<Patient> getAll (){
        return patientsDao.findAll();
    }

    @GetMapping("/getByName/{name}/{surrname}")
    private Patient getByNameSurrname(@PathVariable String name, @PathVariable String surrname){
        return patientsDao.findAll().stream()
                .filter(n->n.getName().equals(name))
                .filter(s->s.getSurrname().equals(surrname))
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/addPatient")
    private void addPatient(@RequestBody Patient patient){
        patientsDao.save(new Patient(patient.getName(),patient.getSurrname(),patient.getPesel(),patient.getBirth(),patient.getAddress()));
    }
}
