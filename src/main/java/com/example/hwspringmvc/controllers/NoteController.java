package com.example.hwspringmvc.controllers;

import com.example.hwspringmvc.entity.Note;
import com.example.hwspringmvc.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/note")
@Controller
public class NoteController {

    private final NoteService noteService;




    // @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ModelAndView getNoteList() { // String
        ModelAndView result = new ModelAndView("noteList");
        result.addObject("noteList",noteService.listAll());
        return result;
    }
}
