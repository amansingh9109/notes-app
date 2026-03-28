package com.aman.NotesApp.controller;

import com.aman.NotesApp.model.Note;
import com.aman.NotesApp.service.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@CrossOrigin
public class NoteController {

    @Autowired
    private NoteService service;

    @PostMapping
    public Note add(@RequestBody Note note) {
        return service.addNote(note);
    }

    @GetMapping
    public List<Note> getAll() {
        return service.getAllNotes();
    }

    @PutMapping("/{id}")
    public Note update(@PathVariable Long id, @RequestBody Note note) {
        return service.updateNote(id, note);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteNote(id);
    }

    @GetMapping("/search")
    public List<Note> search(@RequestParam String query) {
        return service.searchNotes(query);
    }
}
