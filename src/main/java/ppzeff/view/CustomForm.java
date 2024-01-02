package ppzeff.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import ppzeff.entity.Plant;
import ppzeff.entity.Worker;

import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomForm extends FormLayout {

    final Set<Worker> workers;
    final Plant plant;
    ComboBox<Worker> workerComboBox;

    public CustomForm(Set<Worker> workers, Plant plant) {
        this.workers = workers;
        this.plant = plant;
        add(configWorkerComboBox());
    }

    private Component configWorkerComboBox() {
        ComboBox.ItemFilter<Worker> filter = (worker, filterString) -> {
            return filterString.length() >= 3 && worker.getSurname()
                    .toLowerCase()
                    .contains(filterString.toLowerCase());
        };

        workerComboBox = new ComboBox<>("Выберите работника");
        workerComboBox.setItems(filter, workers);
        workerComboBox.setItemLabelGenerator(
                Worker::getName);

        workerComboBox.setClearButtonVisible(true);
        workerComboBox.setRenderer(
                new ComponentRenderer<>(worker -> {
                    FlexLayout wrapper = new FlexLayout();
                    wrapper.setAlignItems(FlexComponent.Alignment.CENTER);

                    Div info = new Div();
                    info.setText(worker.getName());

                    Div profession = new Div();
                    profession.setText(worker.getJobTitle());
                    profession.getStyle().set("font-size", "var(--lumo-font-size-s)");
                    profession.getStyle().set("color", "var(--lumo-secondary-text-color)");
                    info.add(profession);

                    wrapper.add(info);
                    return wrapper;
                }));

        workerComboBox.setRequired(true);

        return workerComboBox;
    }
}
