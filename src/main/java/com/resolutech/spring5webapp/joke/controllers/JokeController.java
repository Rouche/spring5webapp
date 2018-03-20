package com.resolutech.spring5webapp.joke.controllers;

import com.resolutech.spring5webapp.services.ChuckNorrisJokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    private ChuckNorrisJokeService chuckNorrisJokeService;

    public JokeController(ChuckNorrisJokeService chuckNorrisJokeService) {
        this.chuckNorrisJokeService = chuckNorrisJokeService;
    }

    @RequestMapping("/")
    public String getJoke(Model model) {
        model.addAttribute("joke", this.chuckNorrisJokeService.getJoke());

        return "chucknorris";
    }
}
