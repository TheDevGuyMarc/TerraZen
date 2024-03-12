package de.terrazen.zenbreeder.tank.domain;

import de.terrazen.zenbreeder.tank.repository.EnclosureEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Enclosure {
    private Long id;
    private String name;
    private String habitat;
    private double width;
    private double height;
    private double depth;
    private double temperature;
    private double humidity;

    /* TODO: Implement 1-n relation to BreedingGroup */

    public Enclosure(EnclosureEntity model) {
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
