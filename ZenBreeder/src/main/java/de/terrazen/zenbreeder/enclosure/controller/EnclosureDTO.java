package de.terrazen.zenbreeder.enclosure.controller;

import de.terrazen.zenbreeder.breedingGroup.controller.BreedingGroupDTO;
import de.terrazen.zenbreeder.enclosure.domain.Enclosure;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

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
    private final List<BreedingGroupDTO> breedingGroups;

    public EnclosureDTO(Enclosure model) {
        this.id = model.getId();
        this.name = model.getName();
        this.habitat = model.getHabitat();
        this.width = model.getWidth();
        this.height = model.getHeight();
        this.depth = model.getDepth();
        this.temperature = model.getTemperature();
        this.humidity = model.getHumidity();
        this.breedingGroups = model.getBreedingGroups().stream().map(BreedingGroupDTO::new).toList();
    }
}
