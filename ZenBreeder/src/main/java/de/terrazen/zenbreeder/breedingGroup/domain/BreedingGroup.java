package de.terrazen.zenbreeder.breedingGroup.domain;

import de.terrazen.zenbreeder.breedingGroup.repository.BreedingGroupEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class BreedingGroup {
    private Long id;
    private String name;
    private String description;
    private Date paired_at;
    private int animal_amount;

    /* TODO: Implement n-1 relation to EnclosureEntity */
    /* TODO: Implement 1-n relation to AnimalEntity (Group Members) */
    /* TODO: Implement 1-n relation to ClutchEntity */
    /* TODO: Implement n-1 relation to AnimalEntity (Offspring) */
    /* TODO: Implement 1-n relation to NoteEntity */

    public BreedingGroup(BreedingGroupEntity model) {
        this.id = model.getId();
        this.name = model.getName();
        this.description = model.getDescription();
        this.paired_at = model.getPaired_at();
        this.animal_amount = model.getAnimal_amount();
    }
}
