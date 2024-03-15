package de.terrazen.zenbreeder.species.repository;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.terrazen.zenbreeder.animal.repository.AnimalEntity;
import de.terrazen.zenbreeder.species.domain.Species;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @ManyToMany(mappedBy = "species")
    @JsonBackReference
    private List<AnimalEntity> animals;

    public SpeciesEntity(Species model) {
        this.id = model.getId();
        this.name = model.getName();
        this.description = model.getDescription();
        this.animals = model.getAnimals().stream().map(AnimalEntity::new).toList();
    }
}
