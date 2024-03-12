package de.terrazen.zenbreeder.tank.repository;

import de.terrazen.zenbreeder.tank.domain.Enclosure;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tanks")
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

    /* TODO: Implement 1-n relation to BreedingGroupEntity */

    public EnclosureEntity(Enclosure model) {
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
