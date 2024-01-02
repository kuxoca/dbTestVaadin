package ppzeff.service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ppzeff.entity.Plant;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class ScheduledService {
    final CommonService service;

    public ScheduledService(CommonService service) {
        this.service = service;
    }

    @Scheduled(fixedDelay = Long.MAX_VALUE, initialDelay = Long.MAX_VALUE /*10000*/)
    void test() {
        String sCode = "sam";
        log.info("scheduled");
        log.info("step 1");
        Plant plant = service.getPlantBySCode(sCode);

        log.info("step 2");
        log.info("files count {}", plant.getFiles().size());
    }
}
