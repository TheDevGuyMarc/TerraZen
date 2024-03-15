package de.terrazen.zenbreeder.clutch.repository;

import de.terrazen.zenbreeder.breedingGroup.repository.BreedingGroupEntity;
import de.terrazen.zenbreeder.clutch.domain.Clutch;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clutches")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClutchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String condition;

    @Column
    private int egg_amount;

    @ManyToOne
    @JoinColumn(name = "breedingGroup_id", referencedColumnName = "id")
    private BreedingGroupEntity breedingGroup;

    public ClutchEntity(Clutch model) {
        this.id = model.getId();
        this.name = model.getName();
        this.condition = model.getCondition();
        this.egg_amount = model.getEgg_amount();
        this.breedingGroup = new BreedingGroupEntity(model.getBreedingGroup());
    }
}
