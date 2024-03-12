package de.terrazen.zenbreeder.tank.controller;

import de.terrazen.zenbreeder.tank.domain.Enclosure;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EnclosureDTO {
    private Long id;
    private String name;
    private String habitat;
    private double width;
    private double height;
    private double depth;
    private double temperature;
    private double humidity;

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
