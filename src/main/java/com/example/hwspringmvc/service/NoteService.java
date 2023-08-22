package com.example.hwspringmvc.service;

import com.example.hwspringmvc.entity.Note;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Data
@Service
public class NoteService {
    private final Scanner scanner = new Scanner(System.in);

    private List<Note> notes;

    public NoteService() {
        notes = new ArrayList<>();
        add(new Note("title1", "content1"));
        add(new Note("title2", "content2"));
        add(new Note("title3", "content3"));
        add(new Note("title4", "content4"));
        add(new Note("title5", "content5"));
    }



    public List<Note> listAll() {
        return notes;
    }

    public Note add(Note note) {
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
        if (note != null) {
            note.setTitle(scanner.next());
            note.setContent(scanner.next());
            scanner.close();
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
