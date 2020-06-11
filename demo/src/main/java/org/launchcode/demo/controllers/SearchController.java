package org.launchcode.demo.controllers;


import org.launchcode.demo.models.Sneaker;
import org.launchcode.demo.models.SneakerSearch;
import org.launchcode.demo.models.data.SneakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/search")
public class SearchController {

 @Autowired
 private SneakerRepository sneakerRepository;

  @GetMapping("")
    public String renderSearchForm(Model model) {
      model.addAttribute("title","Search Sneaker Profiles ");
      return "search";
  }


  @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchTerm) {
      Iterable<Sneaker> sneakers;
      if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
          sneakers = sneakerRepository.findAll();
      } else {
          sneakers = SneakerSearch.findByValue(searchTerm,sneakerRepository.findAll());
      }
      model.addAttribute("title", "Search Results");
      model.addAttribute("sneakers",sneakers);
    return "search";
  }

}
