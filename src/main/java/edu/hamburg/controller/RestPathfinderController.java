package edu.hamburg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestPathfinderController {
    @RequestMapping("/generate")
    public void generateGraph() {
        System.out.println("generated!");
    }
}
