package de.terrazen.zenbreeder.notes.repository;

import de.terrazen.zenbreeder.breedingGroup.repository.BreedingGroupEntity;
import de.terrazen.zenbreeder.enclosure.repository.EnclosureEntity;
import de.terrazen.zenbreeder.notes.domain.Note;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String note;

    @Column
    private Date created_at;

    @Column
    private Date updated_at;

    @ManyToOne
    @JoinColumn(name = "breedingGroup_id", referencedColumnName = "id")
    private BreedingGroupEntity breedingGroup;

    public NoteEntity(Note model) {
        this.id = model.getId();
        this.title = model.getTitle();
        this.note = model.getNote();
        this.created_at = model.getCreated_at();
        this.updated_at = model.getUpdated_at();
        this.breedingGroup = new BreedingGroupEntity(model.getBreedingGroup());
    }
}
