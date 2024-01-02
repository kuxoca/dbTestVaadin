package ppzeff.service;


import ppzeff.entity.Plant;
import ppzeff.entity.Worker;

import java.util.List;
import java.util.Set;

public interface CommonService {
    List<Plant> getAllPlant();

    Plant getPlantBySCode(String sCode);

    Plant getPlantById(Long id);

    Set<Worker> getWorkerByPlant(Plant plant);
}
