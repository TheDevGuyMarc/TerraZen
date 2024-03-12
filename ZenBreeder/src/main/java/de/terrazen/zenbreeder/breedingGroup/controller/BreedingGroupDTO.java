package de.terrazen.zenbreeder.breedingGroup.controller;

import de.terrazen.zenbreeder.breedingGroup.domain.BreedingGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class BreedingGroupDTO {
    private Long id;
    private String name;
    private String description;
    private Date paired_at;
    private int animal_amount;
    private String notes; // TODO: Move to relation

    /* TODO: Implement n-1 relation to EnclosureEntity */
    /* TODO: Implement 1-n relation to AnimalEntity (Group Members) */
    /* TODO: Implement 1-n relation to ClutchEntity */
    /* TODO: Implement n-1 relation to AnimalEntity (Offspring) */


    public BreedingGroupDTO(BreedingGroup model) {
        this.id = model.getId();
        this.name = model.getName();
        this.description = model.getDescription();
        this.paired_at = model.getPaired_at();
        this.animal_amount = model.getAnimal_amount();
        this.notes = model.getNotes();
    }
}
