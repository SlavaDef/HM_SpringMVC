package com.example.hwspringmvc.service;

import com.example.hwspringmvc.models.Note;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;

@Service
public class NoteMapService {
    private Map<Long, Note> noteMap;

    @PostConstruct
    public void inIt() {

        noteMap = new HashMap<>();
        add(new Note("title1", "content1"));
        add(new Note("title2", "content2"));
        add(new Note("title3", "content3"));
        add(new Note("title4", "content4"));
        add(new Note("title5", "content5"));

    }


    public Map<Long, Note> listAll() {
        return noteMap;

    }

    public Note add(Note note) {
        note.setId(noteMap.size() + 1L);
        noteMap.put(note.getId(), note);
        return note;
    }

    public void deleteById(long id) {
        Note note = noteMap.get(id);
        if (note == null) {
            throw new EmptyStackException();
        } else {
            noteMap.remove(id, note);
        }
    }

    public void update(Note note) {
        if (noteMap.containsKey(note.getId())) {
            noteMap.replace(note.getId(), note);
        } else throw new EmptyStackException();
    }

    public Note getById(long id) {
        Note note = noteMap.get(id);

        if (note == null) {
            throw new EmptyStackException();
        }
        return note;
    }
}
