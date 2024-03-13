package de.terrazen.zenbreeder.species.controller;

import de.terrazen.zenbreeder.species.domain.Species;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SpeciesDTO {
    private final Long id;
    private final String name;
    private final String description;

    /* TODO: Implement n-1 relation to Animal */

    public SpeciesDTO(Species model) {
        this.id = model.getId();
        this.name = model.getName();
        this.description = model.getDescription();
    }
}