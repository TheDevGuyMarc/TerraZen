package de.terrazen.zenbreeder.breedingGroup.controller;

import de.terrazen.zenbreeder.animal.controller.AnimalDTO;
import de.terrazen.zenbreeder.breedingGroup.domain.BreedingGroup;
import de.terrazen.zenbreeder.clutch.controller.ClutchDTO;
import de.terrazen.zenbreeder.enclosure.controller.EnclosureDTO;
import de.terrazen.zenbreeder.notes.controller.NoteDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
public class BreedingGroupDTO {
    private final Long id;
    private final String name;
    private final String description;
    private final Date paired_at;
    private final int animal_amount;
    private final EnclosureDTO enclosure;
    private final List<AnimalDTO> animals;
    private final List<ClutchDTO> clutches;
    private final List<AnimalDTO> offspring;
    private final List<NoteDTO> notes;


    public BreedingGroupDTO(BreedingGroup model) {
        this.id = model.getId();
        this.name = model.getName();
        this.description = model.getDescription();
        this.paired_at = model.getPaired_at();
        this.animal_amount = model.getAnimal_amount();
        this.enclosure = new EnclosureDTO(model.getEnclosure());
        this.animals = model.getAnimals().stream().map(AnimalDTO::new).toList();
        this.clutches = model.getClutches().stream().map(ClutchDTO::new).toList();
        this.offspring = model.getOffspring().stream().map(AnimalDTO::new).toList();
        this.notes = model.getNotes().stream().map(NoteDTO::new).toList();
    }
}
