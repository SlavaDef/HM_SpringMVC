 /*package com.example.hwspringmvc.controllers;

import com.example.hwspringmvc.service.NoteMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RequestMapping("/note")
@Controller
public class NoteMapController {

    private final NoteMapService noteMapService;



    @GetMapping("/list")
    public ModelAndView getNoteList() {
        return new ModelAndView("noteMapList",
                "noteMapList", noteMapService.listAll());
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam Long id){
        noteMapService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit/{id}")
    public String blogEdit(@PathVariable(value = "id") Long id, Model model) {
        if (noteMapService.getById(id)==null) {
            return "redirect:/note/list";
        }
        model.addAttribute("noteMapList", noteMapService.getById(id));
        return "note-edit";
    }
}


*/