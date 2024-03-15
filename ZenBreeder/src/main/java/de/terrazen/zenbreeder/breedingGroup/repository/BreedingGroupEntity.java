package de.terrazen.zenbreeder.breedingGroup.repository;

import de.terrazen.zenbreeder.animal.repository.AnimalEntity;
import de.terrazen.zenbreeder.breedingGroup.domain.BreedingGroup;
import de.terrazen.zenbreeder.clutch.repository.ClutchEntity;
import de.terrazen.zenbreeder.enclosure.repository.EnclosureEntity;
import de.terrazen.zenbreeder.notes.repository.NoteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "enclosure_id", referencedColumnName = "id")
    private EnclosureEntity enclosure;

    @OneToMany(mappedBy = "breedingGroup", cascade = CascadeType.ALL)
    private List<AnimalEntity> animals;

    @OneToMany(mappedBy = "breedingGroup", cascade = CascadeType.ALL)
    private List<ClutchEntity> clutches;

    @OneToMany(mappedBy = "parentGroup", cascade = CascadeType.ALL)
    private List<AnimalEntity> offspring;

    @OneToMany(mappedBy = "breedingGroup", cascade = CascadeType.ALL)
    private List<NoteEntity> notes;

    public BreedingGroupEntity(BreedingGroup model) {
        this.id = model.getId();
        this.name = model.getName();
        this.description = model.getDescription();
        this.paired_at = model.getPaired_at();
        this.animal_amount = model.getAnimal_amount();
        this.enclosure = new EnclosureEntity(model.getEnclosure());
        this.animals = model.getAnimals().stream().map(AnimalEntity::new).toList();
        this.clutches = model.getClutches().stream().map(ClutchEntity::new).toList();
        this.offspring = model.getOffspring().stream().map(AnimalEntity::new).toList();
        this.notes = model.getNotes().stream().map(NoteEntity::new).toList();
    }
}
