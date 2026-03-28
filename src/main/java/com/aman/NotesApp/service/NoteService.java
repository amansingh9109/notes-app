package com.aman.NotesApp.service;

import com.aman.NotesApp.model.Note;
import com.aman.NotesApp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository repo;

    public Note addNote(Note note) {
        return repo.save(note);
    }

    public List<Note> getAllNotes() {
        return repo.findAll();
    }

    public void deleteNote(Long id) {
        repo.deleteById(id);
    }

    public Note updateNote(Long id, Note newNote) {
        Note note = repo.findById(id).orElseThrow();
        note.setTitle(newNote.getTitle());
        note.setContent(newNote.getContent());
        return repo.save(note);
    }

    public List<Note> searchNotes(String query) {
        return repo.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(query, query);
    }
}