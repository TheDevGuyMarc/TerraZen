package de.terrazen.zenbreeder.trait.repository;

import de.terrazen.zenbreeder.trait.domain.Trait;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "traits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TraitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String coloration;

    @Column
    private String medical_position;

    @Column
    private boolean homozygous;

    @Column
    private boolean heterozygous;

    @Column
    private boolean coDominant;

    @Column
    private boolean dominant;

    @Column
    private boolean recessive;

    /* TODO: Implement n-1 relation to Animal */

    public TraitEntity(Trait model) {
        this.id = model.getId();
        this.name = model.getName();
        this.coloration = model.getColoration();
        this.medical_position = model.getMedical_position();
        this.homozygous = model.isHomozygous();
        this.heterozygous = model.isHeterozygous();
        this.coDominant = model.isCoDominant();
        this.dominant = model.isDominant();
        this.recessive = model.isRecessive();
    }
}
