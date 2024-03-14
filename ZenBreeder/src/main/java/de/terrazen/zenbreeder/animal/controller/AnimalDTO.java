package de.terrazen.zenbreeder.animal.controller;

import de.terrazen.zenbreeder.animal.domain.Animal;
import de.terrazen.zenbreeder.breedingGroup.controller.BreedingGroupDTO;
import de.terrazen.zenbreeder.species.controller.SpeciesDTO;
import de.terrazen.zenbreeder.trait.controller.TraitDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

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
    private final BreedingGroupDTO breedingGroup;
    private final BreedingGroupDTO parentGroup;
    private final List<SpeciesDTO> species;
    private final List<TraitDTO> traits;

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
        this.breedingGroup = new BreedingGroupDTO(model.getBreedingGroup());
        this.parentGroup = new BreedingGroupDTO(model.getParentGroup());
        this.species = model.getSpecies().stream().map(SpeciesDTO::new).toList();
        this.traits = model.getTraits().stream().map(TraitDTO::new).toList();
    }
}
