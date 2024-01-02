package ppzeff.controller;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ppzeff.entity.Plant;
import ppzeff.service.CommonService;

@Controller
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
@RequestMapping("api")
public class MyController {

    final CommonService service;

    public MyController(CommonService service) {
        this.service = service;
    }

    @GetMapping("{sCode}")
    @ResponseBody
    public String getData(@PathVariable("sCode") String sCode) {
        log.info("urlParameter: {}", sCode);
        log.info("step 1");
        Plant plant = service.getPlantBySCode(sCode);

        log.info("step 2");
        return String.valueOf(
                plant.getFiles().size()
        );
    }
}
