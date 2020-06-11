package org.launchcode.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/release")
public class ReleaseDatesController {

    @RequestMapping("")
    public String index(Model model){
        model.addAttribute("title", "Sneaker Genius");

        return "release";
    }
}
