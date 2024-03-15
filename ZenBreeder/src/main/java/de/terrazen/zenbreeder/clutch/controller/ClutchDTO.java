package de.terrazen.zenbreeder.clutch.controller;

import de.terrazen.zenbreeder.breedingGroup.controller.BreedingGroupDTO;
import de.terrazen.zenbreeder.clutch.domain.Clutch;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClutchDTO {
    private final Long id;
    private final String name;
    private final String condition;
    private final int egg_amount;
    private final BreedingGroupDTO breedingGroup;

    public ClutchDTO(Clutch model) {
        this.id = model.getId();
        this.name = model.getName();
        this.condition = model.getCondition();
        this.egg_amount = model.getEgg_amount();
        this.breedingGroup = new BreedingGroupDTO(model.getBreedingGroup());
    }
}
