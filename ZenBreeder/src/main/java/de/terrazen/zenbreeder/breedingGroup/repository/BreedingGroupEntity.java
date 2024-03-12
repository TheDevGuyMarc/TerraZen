package de.terrazen.zenbreeder.breedingGroup.repository;

import de.terrazen.zenbreeder.breedingGroup.domain.BreedingGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "breeding-groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BreedingGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Date paired_at;

    @Column
    private int animal_amount;

    @Column
    private String notes; // TODO: Move to relation

    /* TODO: Implement n-1 relation to EnclosureEntity */
    /* TODO: Implement 1-n relation to AnimalEntity (Group Members) */
    /* TODO: Implement 1-n relation to ClutchEntity */
    /* TODO: Implement n-1 relation to AnimalEntity (Offspring) */

    public BreedingGroupEntity(BreedingGroup model) {
        this.id = model.getId();
        this.name = model.getName();
        this.description = model.getDescription();
        this.paired_at = model.getPaired_at();
        this.animal_amount = model.getAnimal_amount();
        this.notes = model.getNotes();
    }
}
