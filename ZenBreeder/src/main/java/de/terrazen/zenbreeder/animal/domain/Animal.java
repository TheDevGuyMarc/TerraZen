package de.terrazen.zenbreeder.animal.domain;

import de.terrazen.zenbreeder.animal.repository.AnimalEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Animal {
    private Long id;
    private String name;
    private String gender;
    private double age;
    private Date hatching_date;
    private Date landing_date;
    private double size;
    private String behaviour;
    private boolean egg_feeder;

    /* TODO: Implement n-1 relation to Breeding Group */
    /* TODO: Implement n-1 relation to Species */
    /* TODO: Implement n-n relation to Traits */

    public Animal(AnimalEntity model) {
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
