package me.zw.workbook.controller;

import me.zw.workbook.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class JournalController {

    private static final String VIEW_INDEX = "index";

    private static final String VIEW_LOGIN = "login";

    @Autowired
    JournalRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName(VIEW_INDEX);
        modelAndView.addObject("journal", repository.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName(VIEW_LOGIN);
        return modelAndView;
    }
}
