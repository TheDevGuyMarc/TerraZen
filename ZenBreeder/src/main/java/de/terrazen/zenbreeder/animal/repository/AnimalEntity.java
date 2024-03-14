package de.terrazen.zenbreeder.animal.repository;

import de.terrazen.zenbreeder.animal.domain.Animal;
import de.terrazen.zenbreeder.species.domain.Species;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "animals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnimalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String gender;

    @Column
    private double age;

    @Column
    private Date hatching_date;

    @Column
    private Date landing_date;

    @Column
    private double size;

    @Column
    private String behaviour;

    @Column
    private boolean egg_feeder;

    /* TODO: Implement n-1 relation to Breeding Group */
    /* TODO: Implement n-1 relation to Species */
    /* TODO: Implement n-n relation to Traits */

    public AnimalEntity(Animal model) {
        this.id = model.getId();
        this.name = model.getName();
        this.gender = model.getGender();
        this.age = model.getAge();
        this.hatching_date = model.getHatching_date();
        this.landing_date = model.getLanding_date();
        this.size = model.getSize();
        this.behaviour = model.getBehaviour();
        this.egg_feeder = model.isEgg_feeder();
    }
}
