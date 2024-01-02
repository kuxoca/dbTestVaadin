package ppzeff.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import ppzeff.entity.Plant;
import ppzeff.service.CommonService;

@PageTitle("Общая страница")
@Route(value = "rnm")
@AnonymousAllowed
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class CommonPage extends VerticalLayout implements HasUrlParameter<String> {
    final CommonService service;

    public CommonPage(CommonService service) {
        this.service = service;
    }

    @Override
    public void setParameter(BeforeEvent event, String parameter) {
        log.info("urlParameter: {}", parameter);

        log.info("step 1");
        Plant plant = service.getPlantBySCode(parameter);

//      однанаправленная связь, ленивая загрузка
        log.info("step 2");
        log.info("files count {}", plant.getFiles().size());


        log.info("plant sCode: {}", plant.getStringCode());

//      двунаправленная связь, можно сделать дополнительный метод
        log.info("plant workers count {}", service.getWorkerByPlant(plant).size());

//      в этом случае будет ошибка
//      log.info("plant workers count {}", plant.getWorkers().size());


    }
}
