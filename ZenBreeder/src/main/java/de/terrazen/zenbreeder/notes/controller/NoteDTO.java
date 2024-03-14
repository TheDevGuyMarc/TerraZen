package de.terrazen.zenbreeder.notes.controller;

import de.terrazen.zenbreeder.breedingGroup.controller.BreedingGroupDTO;
import de.terrazen.zenbreeder.notes.domain.Note;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class NoteDTO {
    private final Long id;
    private final String title;
    private final String note;
    private final Date created_at;
    private final Date updated_at;
    private final BreedingGroupDTO breedingGroup;

    public NoteDTO(Note model) {
        this.id = model.getId();
        this.title = model.getTitle();
        this.note = model.getNote();
        this.created_at = model.getCreated_at();
        this.updated_at = model.getUpdated_at();
        this.breedingGroup = new BreedingGroupDTO(model.getBreedingGroup());
    }
}
