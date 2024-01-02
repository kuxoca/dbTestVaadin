package ppzeff.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ppzeff.entity.DataFile;

public interface DataFileRepo extends JpaRepository<DataFile, Long> {

}
