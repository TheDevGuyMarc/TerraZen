package de.terrazen.zenbreeder.enclosure.domain;

import de.terrazen.zenbreeder.breedingGroup.domain.BreedingGroup;
import de.terrazen.zenbreeder.enclosure.repository.EnclosureEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    private List<BreedingGroup> breedingGroups;

    public Enclosure(EnclosureEntity model) {
        this.id = model.getId();
        this.name = model.getName();
        this.habitat = model.getHabitat();
        this.width = model.getWidth();
        this.height = model.getHeight();
        this.depth = model.getDepth();
        this.temperature = model.getTemperature();
        this.humidity = model.getHumidity();
        this.breedingGroups = model.getBreedingGroups().stream().map(BreedingGroup::new).toList();
    }
}
