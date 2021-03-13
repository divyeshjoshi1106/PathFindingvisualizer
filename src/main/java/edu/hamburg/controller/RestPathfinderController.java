package edu.hamburg.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.hamburg.model.Graph;
import edu.hamburg.util.RandomGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestPathfinderController {
    @RequestMapping("/generate")
    public String generateGraph() throws JsonProcessingException {
        System.out.println("Graph Generated.");
        Graph graph = RandomGenerator.generateRandomGraph(10, 20);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(graph);
    }
}
