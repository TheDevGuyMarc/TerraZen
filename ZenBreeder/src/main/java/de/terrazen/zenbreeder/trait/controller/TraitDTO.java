package de.terrazen.zenbreeder.trait.controller;

import de.terrazen.zenbreeder.trait.domain.Trait;
import lombok.AllArgsConstructor;
import lombok.Getter;

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

    /* TODO: Implement n-1 relation to Animal */

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
    }
}
