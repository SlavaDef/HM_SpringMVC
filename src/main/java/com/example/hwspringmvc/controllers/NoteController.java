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


    @PostMapping("/delete") // /{id}  @PathVariable(value = "id")
    public String deleteNote(@RequestParam Long id, Model model) {

        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit/{id}") // прописуємо динамічний параметр
    public String blogEdit(@PathVariable(value = "id") Long id, Model model) { // від статті
        if (noteService.getById(id)==null) {
            return "redirect:/note/list";
        }
        model.addAttribute("noteList", noteService.getById(id));
        return "note-edit";
    }


    @PostMapping("/edit") // адреса яку ми відслідковуємо
    public String blogPostUpdate( @RequestParam Long id,
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
