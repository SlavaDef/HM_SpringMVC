package com.example.hwspringmvc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Data

public class Note {
    private long id;

    private String title;

    private String content;

    public Note(String title, String content){
        this.title=title;
        this.content = content;
    }


    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
