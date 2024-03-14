package de.terrazen.zenbreeder.species.domain;

import de.terrazen.zenbreeder.animal.domain.Animal;
import de.terrazen.zenbreeder.species.repository.SpeciesEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Species {
    private Long id;
    private String name;
    private String description;
    private List<Animal> animals;

    public Species(SpeciesEntity model) {
        this.id = model.getId();
        this.name = model.getName();
        this.description = model.getDescription();
        this.animals = model.getAnimals().stream().map(Animal::new).toList();
    }
}
