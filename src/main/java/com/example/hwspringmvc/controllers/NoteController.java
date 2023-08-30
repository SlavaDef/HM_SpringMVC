package com.example.hwspringmvc.controllers;

import com.example.hwspringmvc.models.Note;
import com.example.hwspringmvc.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@RequiredArgsConstructor
@RequestMapping("/note")
@Controller
public class NoteController {

    private final NoteService noteService;


    @GetMapping("/list")
    public ModelAndView getNoteList() {
        return new ModelAndView("noteList",
                "noteList", noteService.listAll());
    }


    @PostMapping("/delete")
    public String deleteNote(@RequestParam Long id) {

        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit/{id}")
    public String noteEdit(@PathVariable(value = "id") Long id, Model model) {
        if (noteService.getById(id)==null) {
            return "redirect:/note/list";
        }
        model.addAttribute("noteList", noteService.getById(id));
        return "note-edit";
    }


    @PostMapping("/edit")
    public String noteUpdate( @RequestParam Long id,
                                 @RequestParam String title,
                                 @RequestParam String content,
                                  Model model) {

        Note note = noteService.getById(id);
        note.setTitle(title);
        note.setContent(content);
        noteService.update(note);
        return "redirect:/note/list";
    }
}

//
