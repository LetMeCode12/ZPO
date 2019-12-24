package ProjektAPI.ProjektAPI.RestControllers;


import ProjektAPI.ProjektAPI.Dao.BedDao;
import ProjektAPI.ProjektAPI.Dao.DoctorDao;
import ProjektAPI.ProjektAPI.Dao.PatientsDao;
import ProjektAPI.ProjektAPI.Entity.Bed;
import ProjektAPI.ProjektAPI.Entity.Doctor;
import ProjektAPI.ProjektAPI.Entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;


@RequestMapping("/api/Patients")
@RestController
public class PatientsRest {

    @Autowired
    PatientsDao patientsDao;

    @Autowired
    BedDao bedDao;

    @Autowired
    DoctorDao doctorDao;

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
        patientsDao.save(new Patient(patient.getName(),patient.getSurrname(),patient.getPesel(),patient.getBirth(),patient.getAddress(),patient.getDoctorID(),patient.getBedID()));
    }

    @PutMapping("/addPatientToBed/{patientId}/{bedId}")
    private void addPatientToBed(@PathVariable UUID patientId,@PathVariable UUID bedId){
        Bed bed =bedDao.findAll().stream().parallel().filter(e->e.getIdBed().equals(bedId)).findFirst().orElse(null);
        Patient patient = patientsDao.findAll().stream().parallel().filter(e->e.getId().equals(patientId)).findFirst().orElse(null);
        bed.setIdPatient(patient.getId());
        patient.setBedID(bed.getIdBed());
        bedDao.save(bed);
        patientsDao.save(patient);
    }

    @DeleteMapping("/deletePatient/{patientID}")
    private void delete (@PathVariable UUID patientID){
        Patient patient = patientsDao.findAll().stream().parallel().filter(e->e.getId().equals(patientID)).findFirst().orElse(null);
        Bed bed = bedDao.findAll().stream().parallel().filter(e->e.getIdBed().equals(patient.getBedID())).findFirst().get();
        bed.setIdPatient(null);
        Doctor doctor = doctorDao.findAll().stream().parallel().filter(e->e.getId().equals(patient.getDoctorID())).findFirst().get();
        doctor.getPatients().remove(patient);
        bedDao.save(bed);
        doctorDao.save(doctor);
        patientsDao.delete(patient);
    }
}
