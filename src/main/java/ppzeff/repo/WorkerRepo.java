package ppzeff.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ppzeff.entity.Plant;
import ppzeff.entity.Worker;

import java.util.Set;

public interface WorkerRepo extends JpaRepository<Worker, Long> {
    Set<Worker> findByPlant(Plant plant);
}
