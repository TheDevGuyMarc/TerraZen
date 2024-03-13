package de.terrazen.zenbreeder.species.domain;

import de.terrazen.zenbreeder.species.repository.SpeciesEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Species {
    private Long id;
    private String name;
    private String description;

    /* TODO: Implement n-1 relation to Animal */

    public Species(SpeciesEntity model) {
        this.id = model.getId();
        this.name = model.getName();
        this.description = model.getDescription();
    }
}
