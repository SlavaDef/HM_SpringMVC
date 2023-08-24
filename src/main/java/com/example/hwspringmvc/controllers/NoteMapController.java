/* package com.example.hwspringmvc.controllers;

import com.example.hwspringmvc.service.NoteMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RequestMapping("/noteMap")
@Controller
public class NoteMapController {

    private final NoteMapService noteMapService;


    // @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/listMap")
    public ModelAndView getNoteList() { // String
        ModelAndView result = new ModelAndView("noteMapList");
        result.addObject("noteMapList",noteMapService.listAll());
        return result;
    }

    @PostMapping(value = "/deleteMap/{id}")
    public String delete(@PathVariable(name="id") Long id){
        noteMapService.deleteById(id);
        return "redirect:/noteMap/listMap";
    }
}


 */