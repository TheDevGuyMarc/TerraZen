package de.terrazen.zenbreeder.enclosure.controller;

import de.terrazen.zenbreeder.enclosure.domain.Enclosure;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EnclosureDTO {
    private final Long id;
    private final String name;
    private final String habitat;
    private final double width;
    private final double height;
    private final double depth;
    private final double temperature;
    private final double humidity;

    /* TODO: Implement 1-n relation to BreedingGroupDTO */

    public EnclosureDTO(Enclosure model) {
        this.id = model.getId();
        this.name = model.getName();
        this.habitat = model.getHabitat();
        this.width = model.getWidth();
        this.height = model.getHeight();
        this.depth = model.getDepth();
        this.temperature = model.getTemperature();
        this.humidity = model.getHumidity();
    }
}
