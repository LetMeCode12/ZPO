package ProjektAPI.ProjektAPI.RestControllers;


import ProjektAPI.ProjektAPI.Dao.DoctorDao;
import ProjektAPI.ProjektAPI.Dao.PatientsDao;
import ProjektAPI.ProjektAPI.Entity.Doctor;
import ProjektAPI.ProjektAPI.Entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/Doctors")
@RestController
public class DoctiorsRest  {

    @Autowired
    DoctorDao doctorDao;

    @Autowired
    PatientsDao patientsDao;


    @GetMapping("/getDoctors")
    private List<Doctor> getDoctors(){
        return doctorDao.findAll();
    }

    @PostMapping("/addDoctor")
    private void addDoctor(@RequestBody Doctor doctor){
        doctorDao.save(new Doctor(doctor.getName(),doctor.getSurrname(),doctor.getSpecialization(),doctor.getBranchID()));
    }

    @PutMapping("/addPatientToDoctor/{doctorID}")
    private void addPatienToDoctor(@PathVariable UUID doctorID, @RequestBody Patient patient){
        Doctor doctorTmp =  doctorDao.findAll().stream().parallel().filter(e->e.getId().toString().equals(doctorID.toString())).findFirst().orElse(null);
        Patient patienTmp = patientsDao.findAll().stream().parallel().filter(e->e.getId().equals(patient.getId())).findFirst().orElse(null);
        patienTmp.setDoctorID(doctorTmp.getId());
        doctorTmp.getPatients().add(patienTmp);
        doctorDao.save(doctorTmp);
    }


    @DeleteMapping("/deleteDoctor/{doctorID}")
    private void deleteDoctor(@PathVariable UUID doctorID){
        doctorDao.delete(doctorDao.findAll().stream().parallel().filter(e->e.getId().equals(doctorID)).findFirst().orElse(null));
    }
}
