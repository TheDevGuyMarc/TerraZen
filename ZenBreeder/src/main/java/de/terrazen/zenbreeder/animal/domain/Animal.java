package de.terrazen.zenbreeder.animal.domain;

import de.terrazen.zenbreeder.animal.repository.AnimalEntity;
import de.terrazen.zenbreeder.breedingGroup.domain.BreedingGroup;
import de.terrazen.zenbreeder.species.domain.Species;
import de.terrazen.zenbreeder.trait.domain.Trait;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

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
    private BreedingGroup breedingGroup;
    private BreedingGroup parentGroup;
    private List<Species> species;
    private List<Trait> traits;

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
        this.breedingGroup = new BreedingGroup(model.getBreedingGroup());
        this.parentGroup = new BreedingGroup(model.getParentGroup());
        this.species = model.getSpecies().stream().map(Species::new).toList();
        this.traits = model.getTraits().stream().map(Trait::new).toList();
    }
}
