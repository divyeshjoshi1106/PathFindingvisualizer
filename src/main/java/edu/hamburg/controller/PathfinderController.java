package edu.hamburg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PathfinderController {
    @RequestMapping(value="/home")
    public ModelAndView pathfinder() {
        ModelAndView mav = new ModelAndView();
        List<String> list = new ArrayList<>();

        for(int i = 0; i < 20; i++) {
            list.add("DATA : " + i);
        }

        mav.addObject("name", "Sample Data");
        mav.addObject("list", list);
        mav.setViewName("hello");

        return mav;
    }
}
