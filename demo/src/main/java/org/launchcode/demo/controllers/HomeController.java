package org.launchcode.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    AuthenticationController authenticationController;


    @RequestMapping("")
    public String index(Model model){

        model.addAttribute("title", "Sneaker Genius");

        return "index";
    }


}
