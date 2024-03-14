package de.terrazen.zenbreeder.enclosure.repository;

import de.terrazen.zenbreeder.breedingGroup.domain.BreedingGroup;
import de.terrazen.zenbreeder.breedingGroup.repository.BreedingGroupEntity;
import de.terrazen.zenbreeder.enclosure.domain.Enclosure;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "enclosures")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnclosureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String habitat;

    @Column
    private double width;

    @Column
    private double height;

    @Column
    private double depth;

    @Column
    private double temperature;

    @Column
    private double humidity;

    @OneToMany(mappedBy = "enclosure", cascade = CascadeType.ALL)
    private List<BreedingGroupEntity> breedingGroups;

    public EnclosureEntity(Enclosure model) {
        this.id = model.getId();
        this.name = model.getName();
        this.habitat = model.getHabitat();
        this.width = model.getWidth();
        this.height = model.getHeight();
        this.depth = model.getDepth();
        this.temperature = model.getTemperature();
        this.humidity = model.getHumidity();
        this.breedingGroups = model.getBreedingGroups().stream().map(BreedingGroupEntity::new).toList();
    }
}
