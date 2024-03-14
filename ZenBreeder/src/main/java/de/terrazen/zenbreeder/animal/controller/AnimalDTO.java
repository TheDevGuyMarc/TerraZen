package de.terrazen.zenbreeder.animal.controller;

import de.terrazen.zenbreeder.animal.domain.Animal;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class AnimalDTO {
    private final Long id;
    private final String name;
    private final String gender;
    private final double age;
    private final Date hatching_date;
    private final Date landing_date;
    private final double size;
    private final String behaviour;
    private final boolean egg_feeder;

    /* TODO: Implement n-1 relation to Breeding Group */
    /* TODO: Implement n-1 relation to Species */
    /* TODO: Implement n-n relation to Traits */

    public AnimalDTO(Animal model) {
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
