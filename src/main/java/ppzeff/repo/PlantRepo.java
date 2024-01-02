package ppzeff.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import ppzeff.entity.Plant;

public interface PlantRepo extends JpaRepository<Plant, Long> {
    Plant findByStringCode(String sCode);
}
