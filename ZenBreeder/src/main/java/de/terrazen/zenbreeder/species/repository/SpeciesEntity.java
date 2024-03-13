package de.terrazen.zenbreeder.species.repository;

import de.terrazen.zenbreeder.species.domain.Species;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "species")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpeciesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    /* TODO: Implement n-1 relation to Animal */

    public SpeciesEntity(Species model) {
        this.id = model.getId();
        this.name = model.getName();
        this.description = model.getDescription();
    }
}
