package ProjektAPI.ProjektAPI.RestControllers;


import ProjektAPI.ProjektAPI.Dao.BedDao;
import ProjektAPI.ProjektAPI.Dao.BranchDao;
import ProjektAPI.ProjektAPI.Dao.BuildingsDao;
import ProjektAPI.ProjektAPI.Dao.RoomDao;
import ProjektAPI.ProjektAPI.Entity.Bed;
import ProjektAPI.ProjektAPI.Entity.Branch;
import ProjektAPI.ProjektAPI.Entity.Building;
import ProjektAPI.ProjektAPI.Entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/Buildings")
@RestController
public class BuildingsRest {

    @Autowired
    BuildingsDao buildingsDao;
    @Autowired
    BranchDao branchDao;

    @Autowired
    RoomDao roomDao;

    @Autowired
    BedDao bedDao;

//    private List<Branch> getBranchByName(String Name){
//        List<Branch> branches =  new ArrayList<>();
//        branches.add(branchDao.findAll().stream().parallel().filter(e->e.getBranch_Name().equals(Name)).findFirst().orElse(null));
//        return branches;
//
//    };
//
//    private Building getBuildingByAdress(String Addres){
//        return buildingsDao.findAll().stream().filter(e->e.getAddress().equals(Addres)).findFirst().orElse(null);
//    }

    @PostMapping("/addBuilding")
    private void addBuilding(@RequestBody Building building ){
        buildingsDao.save(new Building(building.getNr_Budynku(),building.getAddress()));
    }

    @PutMapping("/addBranch/{nameBd}/{nrBd}")
    private void addBranch(@RequestBody Branch branch,@PathVariable String nameBd,@PathVariable Integer nrBd){
        Building bd = buildingsDao.findAll().stream().parallel().filter(e->e.getAddress().equals(nameBd)).filter(r->r.getNr_Budynku().equals(nrBd)).findFirst().orElse(null);
        Branch new_branch = new Branch(branch.getNr_Branch(),branch.getBranch_Name());
        branchDao.save(new_branch);
        //Branch br = branchDao.findAll().stream().parallel().filter(e->e.getId().equals(branch.getId())).findFirst().orElse(null);
        bd.getBranches().add(new_branch);
        buildingsDao.save(bd);
    }

    @PutMapping("/updateBranch/addRoom/{nameBd}/{nrBd}/{nameBr}/{nrBr}")
    private void updateBranchAddRoom (@RequestBody Room room,@PathVariable String nameBd,@PathVariable Integer nrBd,@PathVariable String nameBr,@PathVariable Integer nrBr){
       Building bd = buildingsDao.findAll().stream().parallel().filter(e->e.getAddress().equals(nameBd)).filter(r->r.getNr_Budynku().equals(nrBd)).findFirst().orElse(null);
       Branch br = bd.getBranches().stream().parallel().filter(e->e.getBranch_Name().equals(nameBr)).filter(r->r.getNr_Branch()==nrBr).findFirst().orElse(null);
        Room rm = new Room(room.getNr_Room());
       roomDao.save(rm);
       br.getRooms().add(rm);
       branchDao.save(br);
    }

    @PutMapping("/addBedToRoom/{nameBd}/{nrBd}/{nameBr}/{nrBr}/{nrRoom}")
    private void updateRoom (@RequestBody Bed bed,@PathVariable String nameBd,@PathVariable Integer nrBd,@PathVariable String nameBr,@PathVariable Integer nrBr, @PathVariable Integer nrRoom ){
        Building bd = buildingsDao.findAll().stream().parallel().filter(e->e.getAddress().equals(nameBd)).filter(r->r.getNr_Budynku().equals(nrBd)).findFirst().orElse(null);
        Branch br = bd.getBranches().stream().parallel().filter(e->e.getBranch_Name().equals(nameBr)).filter(r->r.getNr_Branch()==nrBr).findFirst().orElse(null);
        Room rm = br.getRooms().stream().parallel().filter(e->e.getNr_Room().equals(nrRoom)).findFirst().orElse(null);
        Bed _bed = new Bed(bed.getNrBed(),bed.getIdPatient());
        bedDao.save(_bed);
        rm.getBeds().add(_bed);
        roomDao.save(rm);
    }


//    @PutMapping("/addBranchtoBld/{buildingName}/{nameBranch}")
//    private void addBranchToBld(@PathVariable String buildingName,@PathVariable String nameBranch){
//
//       Building bd = buildingsDao.findAll().stream().parallel().filter(e->e.getAddress().equals(buildingName)).findFirst().orElse(null);
//       bd.getBranches().add(branchDao.findAll().stream().parallel().filter(e->e.getBranch_Name().equals(nameBranch)).findFirst().orElse(null));
//      // buildingsDao.delete(buildingsDao.findAll().stream().filter(e->e.getAddress().equals(buildingName)).findFirst().orElse(null));
//       buildingsDao.save(bd);
//
//    }

    @GetMapping("/getAll")
    private List<Building> getAllBuilding(){
        return buildingsDao.findAll();
    }

    @GetMapping("/getAllBranch")
    private List<Branch> getAllBranch(){
        return branchDao.findAll();
    }

    @DeleteMapping("/deleteBuilding/{name}")
    private void deleteBuilding(@PathVariable String name){
        buildingsDao.delete(buildingsDao.findAll().stream().parallel().filter(e->e.getAddress().equals(name)).findFirst().orElse(null));
    }

    @GetMapping("/getBranchesfrom/{name}")
    private List<Branch> getBranchesfromBd(@PathVariable String name){

        return buildingsDao.findAll().stream().parallel().filter(e->e.getAddress().equals(name)).map(e->e.getBranches()).findFirst().orElse(null);

    }

    @PutMapping("/updateBranch/{name}")
    private void updateBranch (@PathVariable String name,@RequestBody Branch branch){
        Branch br = branchDao.findAll().stream().parallel().filter(e->e.getBranch_Name().equals(name)).findFirst().orElse(null);
       // br.setBeds_amount(branch.getBeds_amount());
        branchDao.save(br);
    }



}
