package ppzeff.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ppzeff.entity.Plant;
import ppzeff.entity.Worker;
import ppzeff.repo.DataFileRepo;
import ppzeff.repo.PlantRepo;
import ppzeff.repo.WorkerRepo;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class CommonServiceImpl implements CommonService {
    private final PlantRepo plantRepo;
    private final WorkerRepo workerRepo;

    public CommonServiceImpl(PlantRepo plantRepo, WorkerRepo workerRepo) {
        this.plantRepo = plantRepo;
        this.workerRepo = workerRepo;

    }

    @Override
    public Plant getPlantBySCode(String sCode) {
        return plantRepo.findByStringCode(sCode);
    }

    @Override
    public Set<Worker> getWorkerByPlant(Plant plant) {
        return workerRepo.findByPlant(plant);
    }

    @Override
    public List<Plant> getAllPlant() {
        return plantRepo.findAll();
    }

    @Override
    public Plant getPlantById(Long id) {
        return plantRepo.findById(id).get();
    }

}
