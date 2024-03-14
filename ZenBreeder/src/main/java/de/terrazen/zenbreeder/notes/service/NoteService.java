package de.terrazen.zenbreeder.notes.service;

import de.terrazen.zenbreeder.notes.domain.Note;
import de.terrazen.zenbreeder.notes.exception.NoteNotFoundException;
import de.terrazen.zenbreeder.notes.repository.NoteEntity;
import de.terrazen.zenbreeder.notes.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> findAllNotes() {
        return this.noteRepository.findAll()
            .stream()
            .map(Note::new)
            .toList();
    }

    public Optional<Note> findNoteById(Long id) {
        return this.noteRepository.findById(id)
            .map(Note::new);
    }

    public Note createNote(Note note) {
        return new Note(this.noteRepository.saveAndFlush(new NoteEntity(note)));
    }

    public Note updateNote(Long id, Note note) {
        Optional<Note> existingElement = this.noteRepository.findById(id)
            .map(Note::new);

        if (existingElement.isPresent()) {
            Note updatedElement = existingElement.get();

            updatedElement.setId(note.getId());
            updatedElement.setTitle(note.getTitle());
            updatedElement.setNote(note.getNote());
            updatedElement.setCreated_at(note.getCreated_at());
            updatedElement.setUpdated_at(note.getUpdated_at());

            return new Note(this.noteRepository.saveAndFlush(new NoteEntity(updatedElement)));
        }
        else {
            throw new NoteNotFoundException("Couldn't find the note entry you requested with id: " + id);
        }
    }

    public void deleteNote(Long id) {
        this.noteRepository.deleteById(id);
    }
}
