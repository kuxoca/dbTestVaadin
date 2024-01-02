package ppzeff.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Plant extends AbstractEntity {
    int code;
    String name;
    String stringCode;
    String fullStringCode;
    String avatarLink;
    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "plant_id")
    Set<Worker> workers = new HashSet<>();

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "plant_id")
    Set<Shift> shifts = new HashSet<>();
    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "plant_id")
    Set<Place> places = new HashSet<>();

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL)
    Set<DataFile> files = new HashSet<>();
}
