package de.terrazen.zenbreeder.species.controller;

import de.terrazen.zenbreeder.animal.controller.AnimalDTO;
import de.terrazen.zenbreeder.animal.repository.AnimalEntity;
import de.terrazen.zenbreeder.species.domain.Species;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class SpeciesDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final List<AnimalDTO> animals;

    public SpeciesDTO(Species model) {
        this.id = model.getId();
        this.name = model.getName();
        this.description = model.getDescription();
        this.animals = model.getAnimals().stream().map(AnimalDTO::new).toList();
    }
}
