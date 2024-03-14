package de.terrazen.zenbreeder.animal.repository;

import de.terrazen.zenbreeder.animal.domain.Animal;
import de.terrazen.zenbreeder.breedingGroup.repository.BreedingGroupEntity;
import de.terrazen.zenbreeder.species.repository.SpeciesEntity;
import de.terrazen.zenbreeder.trait.repository.TraitEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "animals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnimalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String gender;

    @Column
    private double age;

    @Column
    private Date hatching_date;

    @Column
    private Date landing_date;

    @Column
    private double size;

    @Column
    private String behaviour;

    @Column
    private boolean egg_feeder;

    @ManyToOne
    @JoinColumn(name = "breedingGroup_id", referencedColumnName = "id")
    private BreedingGroupEntity breedingGroup;

    @ManyToOne
    @JoinColumn(name = "breedingGroupOffspring_id", referencedColumnName = "id")
    private BreedingGroupEntity parentGroup;

    @ManyToMany
    @JoinTable(
        name = "animal_species",
        joinColumns = @JoinColumn(name = "animal_id"),
        inverseJoinColumns = @JoinColumn(name = "species_id")
    )
    private List<SpeciesEntity> species;

    @ManyToMany
    @JoinTable(
        name = "animal_traits",
        joinColumns = @JoinColumn(name = "animal_id"),
        inverseJoinColumns = @JoinColumn(name = "traits_id")
    )
    private List<TraitEntity> traits;

    public AnimalEntity(Animal model) {
        this.id = model.getId();
        this.name = model.getName();
        this.gender = model.getGender();
        this.age = model.getAge();
        this.hatching_date = model.getHatching_date();
        this.landing_date = model.getLanding_date();
        this.size = model.getSize();
        this.behaviour = model.getBehaviour();
        this.egg_feeder = model.isEgg_feeder();
        this.breedingGroup = new BreedingGroupEntity(model.getBreedingGroup());
        this.parentGroup = new BreedingGroupEntity(model.getParentGroup());
        this.species = model.getSpecies().stream().map(SpeciesEntity::new).toList();
        this.traits = model.getTraits().stream().map(TraitEntity::new).toList();
    }
}
