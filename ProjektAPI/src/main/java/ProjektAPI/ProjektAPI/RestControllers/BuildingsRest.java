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


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/Buildings")
public class BuildingsRest {

    BuildingsDao buildingsDao;

    BranchDao branchDao;

    RoomDao roomDao;

    BedDao bedDao;

    @Autowired
    private BuildingsRest(BuildingsDao buildingsDao,BranchDao branchDao, RoomDao roomDao, BedDao bedDao){
        this.buildingsDao = buildingsDao;
        this.bedDao=bedDao;
        this.branchDao=branchDao;
        this.roomDao=roomDao;
    }


    @PostMapping("/addBuilding")
    private void addBuilding(@RequestBody Building building ){
        buildingsDao.save(new Building(building.getNr_Budynku(),building.getAddress()));
    }

    @PutMapping("/addBranch/{id}")
    private void addBranch(@RequestBody Branch branch,@PathVariable UUID id){
        Building bd = buildingsDao.findAll().stream().parallel().filter(e->e.getId().equals(id)).findFirst().orElse(null);
        Branch new_branch = new Branch(branch.getNr_Branch(),branch.getBranch_Name(),branch.getBuildingID());
        branchDao.save(new_branch);
        bd.getBranches().add(new_branch);
        buildingsDao.save(bd);
    }

    @PutMapping("/updateBranch/addRoom/{BdId}/{BrId}")
    private void updateBranchAddRoom (@RequestBody Room room,@PathVariable UUID BdId,@PathVariable UUID BrId ){
       Building bd = buildingsDao.findAll().stream().parallel().filter(e->e.getId().equals(BdId)).findFirst().orElse(null);
       Branch br = bd.getBranches().stream().parallel().filter(e->e.getId().equals(BrId)).findFirst().orElse(null);
        Room rm = new Room(room.getNr_Room(),room.getBranchID());
       roomDao.save(rm);
       br.getRooms().add(rm);
       branchDao.save(br);
    }

    @PutMapping("/addBedToRoom/{BdId}/{BrId}/{RoomId}")
    private void updateRoom (@RequestBody Bed bed,@PathVariable UUID BdId,@PathVariable UUID BrId,@PathVariable UUID RoomId ){
        Building bd = buildingsDao.findAll().stream().parallel().filter(e->e.getId().equals(BdId)).findFirst().orElse(null);
        Branch br = bd.getBranches().stream().parallel().filter(e->e.getId().equals(BrId)).findFirst().orElse(null);
        Room rm = br.getRooms().stream().parallel().filter(e->e.getId().equals(RoomId)).findFirst().orElse(null);
        Bed _bed = new Bed(bed.getNrBed(),bed.getIdPatient(),bed.getRoomID());
        bedDao.save(_bed);
        rm.getBeds().add(_bed);
        roomDao.save(rm);
    }

    @GetMapping("/getAll")
    private List<Building> getAllBuilding(){
        return buildingsDao.findAll();
    }

    @GetMapping("/getAllBranch")
    private List<Branch> getAllBranch(){
        return branchDao.findAll();
    }

    @DeleteMapping("/deleteBuilding/{id}")
    private void deleteBuilding(@PathVariable UUID id){
        buildingsDao.delete(buildingsDao.findAll().stream().parallel().filter(e->e.getId().equals(id)).findFirst().orElse(null));
    }

    @GetMapping("/getBranchesfrom/{name}")
    private List<Branch> getBranchesfromBd(@PathVariable String name){

        return buildingsDao.findAll().stream().parallel().filter(e->e.getAddress().equals(name)).map(e->e.getBranches()).findFirst().orElse(null);

    }

    @PutMapping("/updateBranch/{name}")
    private void updateBranch (@PathVariable String name,@RequestBody Branch branch){
        Branch br = branchDao.findAll().stream().parallel().filter(e->e.getBranch_Name().equals(name)).findFirst().orElse(null);
        branchDao.save(br);
    }


    @DeleteMapping("/branchDelete/{idBranch}")
    private void deleteBranch (@PathVariable UUID idBranch){
        System.out.println("TU:"+ branchDao.findAll().stream().parallel().filter(e->e.getId().equals(idBranch)).findFirst().orElse(null).getId());
       try {
           Branch branch = branchDao.findAll().stream().parallel().filter(e -> e.getId().equals(idBranch)).findFirst().orElse(null);

           Building building = buildingsDao.findAll().stream().parallel().filter(a->a.getId().equals(branch.getBuildingID())).findFirst().orElse(null);

           building.getBranches().remove(branch);

           buildingsDao.save(building);

           branchDao.delete(branch);
       }catch (Exception e){
            throw e;
       }
    }

    @DeleteMapping("/roomDelete/{idRoom}")
    private void deleteRoom (@PathVariable UUID idRoom){
        try {
            Room room = roomDao.findAll().stream().parallel().filter(r->r.getId().equals(idRoom)).findFirst().orElse(null);

            Branch branch = branchDao.findAll().stream().parallel().filter(e -> e.getId().equals(room.getBranchID())).findFirst().orElse(null);

            branch.getRooms().remove(room);

            branchDao.save(branch);

            roomDao.delete(room);
        }catch (Exception e){
            throw e;
        }
    }

    @DeleteMapping("/bedDelete/{bedID}")
    private void deleteBed (@PathVariable UUID bedID){
        try {
            Bed bed = bedDao.findAll().stream().parallel().filter(r->r.getIdBed().equals(bedID)).findFirst().orElse(null);

            Room room = roomDao.findAll().stream().parallel().filter(e -> e.getId().equals(bed.getRoomID())).findFirst().orElse(null);

            room.getBeds().remove(bed);

            roomDao.save(room);

            bedDao.delete(bed);
        }catch (Exception e){
            throw e;
        }
    }

}
