package ppzeff.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Worker extends AbstractEntity {
    String surname;
    String name;
    String patronymic;
    String jobTitle;
    String subdivision;
    @ManyToOne(cascade = CascadeType.ALL)
    Plant plant;
}
