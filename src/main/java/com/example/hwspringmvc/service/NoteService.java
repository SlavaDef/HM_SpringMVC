package com.example.hwspringmvc.service;

import com.example.hwspringmvc.models.Note;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Data
@Service
public class NoteService {

    private List<Note> notes;


    public NoteService() {

        this.notes = new ArrayList<>();
        
 }

     @PostConstruct
    public void addingNotes(){
        addNote(new Note("title0", "content0"));
        addNote(new Note("title2", "content2"));
        addNote(new Note("title3", "content3"));
        addNote(new Note("title4", "content4"));
        addNote(new Note("title5", "content5"));
    }


    public List<Note> listAll() {
        return notes;
    }

    public void addNote(Note note) {
        note.setId(notes.size() + 1L);
        notes.add(note);
    }

    public void deleteById(long id){
        notes.stream().filter(note -> note.getId().longValue() == id)
                .findFirst().ifPresent((note -> notes.remove(note)));
    }

    public void update(Long id, String title, String content){
         Note note = this.getById(id);

        note.setTitle(title);
        note.setContent(content);
    }

    public Note getById(Long id) {

        List<Note> noteList = notes
                .stream().filter(note -> note.getId().longValue() == id)
                .collect(Collectors.toList());
        return noteList.get(0);

    }
}
