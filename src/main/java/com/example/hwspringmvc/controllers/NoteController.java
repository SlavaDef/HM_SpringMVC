package com.example.hwspringmvc.controllers;

import com.example.hwspringmvc.entity.Note;
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


    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ModelAndView getNoteList() {
        return new ModelAndView("noteList",
                "noteList", noteService.listAll());
    }

  /*  @RequestMapping(method = RequestMethod.POST, value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    } */

    @PostMapping("/delete")
    public String postCurrentTimeXFormUrlEncoded(@RequestParam long id, Model model) {
        noteService.getById(id);
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

  /*  @RequestMapping(method = RequestMethod.GET, value = "/edit/{id}")
    public ModelAndView editeNote(long id) { // String

    } */

    // @RequestMapping(params="action=save")
    @PostMapping(value = "/edit")
    public ModelAndView save(@ModelAttribute("noteList") Note note) {
        noteService.update(note);
        return new ModelAndView("redirect:/note/list", "noteList", note.getId());
    }


  /*  @PostMapping(value = "/edit")
    public String editNote(Note note){
        noteService.update(note);
        return "redirect:/note/list";
    }  */

}
