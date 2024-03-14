package de.terrazen.zenbreeder.breedingGroup.domain;

import de.terrazen.zenbreeder.animal.domain.Animal;
import de.terrazen.zenbreeder.breedingGroup.repository.BreedingGroupEntity;
import de.terrazen.zenbreeder.clutch.domain.Clutch;
import de.terrazen.zenbreeder.enclosure.domain.Enclosure;
import de.terrazen.zenbreeder.notes.domain.Note;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BreedingGroup {
    private Long id;
    private String name;
    private String description;
    private Date paired_at;
    private int animal_amount;
    private Enclosure enclosure;
    private List<Animal> animals;
    private List<Clutch> clutches;
    private List<Animal> offspring;
    private List<Note> notes;

    public BreedingGroup(BreedingGroupEntity model) {
        this.id = model.getId();
        this.name = model.getName();
        this.description = model.getDescription();
        this.paired_at = model.getPaired_at();
        this.animal_amount = model.getAnimal_amount();
        this.enclosure = new Enclosure(model.getEnclosure());
        this.animals = model.getAnimals().stream().map(Animal::new).toList();
        this.clutches = model.getClutches().stream().map(Clutch::new).toList();
        this.offspring = model.getOffspring().stream().map(Animal::new).toList();
        this.notes = model.getNotes().stream().map(Note::new).toList();
    }
}
