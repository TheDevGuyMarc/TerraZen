package de.terrazen.zenbreeder.clutch.domain;

import de.terrazen.zenbreeder.breedingGroup.domain.BreedingGroup;
import de.terrazen.zenbreeder.clutch.repository.ClutchEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Clutch {
    private Long id;
    private String name;
    private String condition;
    private int egg_amount;
    private BreedingGroup breedingGroup;

    public Clutch(ClutchEntity model) {
        this.id = model.getId();
        this.name = model.getName();
        this.condition = model.getCondition();
        this.egg_amount = model.getEgg_amount();
        this.breedingGroup = new BreedingGroup(model.getBreedingGroup());
    }
}
