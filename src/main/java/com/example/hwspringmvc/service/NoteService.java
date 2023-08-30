package com.example.hwspringmvc.service;

import com.example.hwspringmvc.models.Note;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.*;

@Data
@Service
public class NoteService {

    private List<Note> notes;

    public NoteService() {

        this.notes = new ArrayList<>();

        notes.add(new Note(0L,"title0", "content0"));
        notes.add(new Note(1L,"title1", "content1"));
        notes.add(new Note(2L,"title2", "content2"));
        notes.add(new Note(3L,"title3", "content3"));
        notes.add(new Note(4L,"title4", "content4"));
        notes.add(new Note(5L,"title5", "content5"));
        notes.add(new Note(6L,"title6", "content6"));

    }


    public List<Note> listAll() {
        return notes;
    }

    public Note addNote(Note note) {
        note.setId(notes.size() + 1L);
        notes.add(note);
        return note;
    }

    public void deleteById(long id) {
        Note note = notes.get((int) id);
        if (note == null) {
            throw new EmptyStackException();
        } else
            notes.remove(Math.toIntExact(id));
    }

    public void update(Note note) {

        if (note.getId() >= 0) {
            note.setTitle(note.getTitle());
            note.setContent(note.getContent());
        } else throw new EmptyStackException();
    }

    public Note getById(long id) {
        Note note = notes.get(Math.toIntExact(id));
        if (note == null) {
            throw new EmptyStackException();
        }
        return note;
    }

}
