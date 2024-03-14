package de.terrazen.zenbreeder.notes.controller;

import de.terrazen.zenbreeder.notes.domain.Note;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class NoteDTO {
    private Long id;
    private String title;
    private String note;
    private Date created_at;
    private Date updated_at;

    /* TODO: Implement n-1 relation to Breeding Group */

    public NoteDTO(Note model) {
        this.id = model.getId();
        this.title = model.getTitle();
        this.note = model.getNote();
        this.created_at = model.getCreated_at();
        this.updated_at = model.getUpdated_at();
    }
}
