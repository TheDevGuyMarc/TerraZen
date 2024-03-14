package de.terrazen.zenbreeder.trait.controller;

import de.terrazen.zenbreeder.animal.controller.AnimalDTO;
import de.terrazen.zenbreeder.animal.repository.AnimalEntity;
import de.terrazen.zenbreeder.trait.domain.Trait;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TraitDTO {
    private final Long id;
    private final String name;
    private final String coloration;
    private final String medical_position;
    private final boolean homozygous;
    private final boolean heterozygous;
    private final boolean coDominant;
    private final boolean dominant;
    private final boolean recessive;
    private final List<AnimalDTO> animals;

    public TraitDTO(Trait model) {
        this.id = model.getId();
        this.name = model.getName();
        this.coloration = model.getColoration();
        this.medical_position = model.getMedical_position();
        this.homozygous = model.isHomozygous();
        this.heterozygous = model.isHeterozygous();
        this.coDominant = model.isCoDominant();
        this.dominant = model.isDominant();
        this.recessive = model.isRecessive();
        this.animals = model.getAnimals().stream().map(AnimalDTO::new).toList();
    }
}
