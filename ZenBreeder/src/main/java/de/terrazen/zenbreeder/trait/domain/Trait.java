package de.terrazen.zenbreeder.trait.domain;

import de.terrazen.zenbreeder.animal.domain.Animal;
import de.terrazen.zenbreeder.animal.repository.AnimalEntity;
import de.terrazen.zenbreeder.trait.repository.TraitEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Trait {
    private Long id;
    private String name;
    private String coloration;
    private String medical_position;
    private boolean homozygous;
    private boolean heterozygous;
    private boolean coDominant;
    private boolean dominant;
    private boolean recessive;
    private List<Animal> animals;

    public Trait(TraitEntity model) {
        this.id = model.getId();
        this.name = model.getName();
        this.coloration = model.getColoration();
        this.medical_position = model.getMedical_position();
        this.homozygous = model.isHomozygous();
        this.heterozygous = model.isHeterozygous();
        this.coDominant = model.isCoDominant();
        this.dominant = model.isDominant();
        this.recessive = model.isRecessive();
        this.animals = model.getAnimals().stream().map(Animal::new).toList();
    }
}
