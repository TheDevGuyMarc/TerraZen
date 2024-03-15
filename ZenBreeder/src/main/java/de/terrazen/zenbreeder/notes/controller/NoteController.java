package de.terrazen.zenbreeder.notes.controller;

import de.terrazen.zenbreeder.notes.domain.Note;
import de.terrazen.zenbreeder.notes.service.NoteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<NoteDTO> list() {
        return this.noteService.findAllNotes()
            .stream()
            .map(NoteDTO::new)
            .toList();
    }

    @GetMapping("/{id}")
    public NoteDTO read(@PathVariable @Min(1) Long id) {
        return this.noteService.findNoteById(id)
            .map(NoteDTO::new)
            .orElseThrow();
    }

    @PostMapping
    public NoteDTO create(@RequestBody @Valid @NotNull @NotEmpty Note note) {
        return new NoteDTO(this.noteService.createNote(note));
    }

    @PutMapping("/{id}")
    public NoteDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Note note) {
        return new NoteDTO(this.noteService.updateNote(id, note));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.noteService.deleteNote(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
