package de.terrazen.zenbreeder.notes.domain;

import de.terrazen.zenbreeder.breedingGroup.domain.BreedingGroup;
import de.terrazen.zenbreeder.notes.repository.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Note {
    private Long id;
    private String title;
    private String note;
    private Date created_at;
    private Date updated_at;
    private BreedingGroup breedingGroup;

    public Note(NoteEntity model) {
        this.id = model.getId();
        this.title = model.getTitle();
        this.note = model.getNote();
        this.created_at = model.getCreated_at();
        this.updated_at = model.getUpdated_at();
        this.breedingGroup = new BreedingGroup(model.getBreedingGroup());
    }
}
