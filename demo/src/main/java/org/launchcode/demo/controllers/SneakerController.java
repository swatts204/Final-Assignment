package org.launchcode.demo.controllers;

import org.launchcode.demo.models.Sneaker;
import org.launchcode.demo.models.data.SneakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("sneakers")
public class SneakerController {

    @Autowired
    private SneakerRepository sneakerRepository;

    @GetMapping
    public String displayAllSneakerProfiles(Model model){
        model.addAttribute("title", "Sneaker Profiles");
        model.addAttribute("sneakers", sneakerRepository.findAll());
        return "sneakers/index";
    }
    @GetMapping("add")
    public String displayAddSneakerForm(Model model) {
        model.addAttribute("title", "Add Sneaker Profile");
        model.addAttribute(new Sneaker());
        return "sneakers/add";
    }
    @PostMapping("add")
    public String processCreateSneakerForm(@ModelAttribute @Valid Sneaker newSneaker, Errors errors, Model model){
        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Sneaker Profile");
            return "sneakers/add";
        }

        sneakerRepository.save(newSneaker);
        return "redirect:";
    }
    @GetMapping("delete")
    public String displayDeleteSneakerForm(Model model) {
        model.addAttribute("title", "Delete Sneaker Profile");
        model.addAttribute("sneakers", sneakerRepository.findAll());
        return "sneakers/delete";
    }

    @PostMapping("delete")
    public String processDeleteSneakerForm(@RequestParam(required = false) int[] sneakerIds) {

        if (sneakerIds != null) {
            for (int id : sneakerIds) {
                sneakerRepository.deleteById(id);
            }
        }

        return "redirect:";
    }
    @GetMapping("edit/{sneakerId}")
    public String displayEditForm(Model model, @PathVariable int sneakerId){
        Optional<Sneaker> sneakerContainer = sneakerRepository.findById(sneakerId);
        Sneaker sneakerToEdit = sneakerContainer.get();

        model.addAttribute("sneaker, sneakerToEdit");
        String title= "Edit Sneaker Profile" + sneakerToEdit.getName() + "(id=" + sneakerToEdit.getId() +")";
        model.addAttribute("title", title);

        return "sneakers/edit";
    }
    @PostMapping("edit")
    public String processEditForm(int sneakerId, String name, String designer, String colorway, String releaseDate, String retailPrice, String description, String image ){
        Sneaker sneakerToEdit = sneakerRepository.findById(sneakerId).get();

        sneakerToEdit.setName(name);
        sneakerToEdit.setDesigner(designer);
        sneakerToEdit.setColorway(colorway);
        sneakerToEdit.setReleaseDate(releaseDate);
        sneakerToEdit.setDescription(description);

        sneakerRepository.save(sneakerToEdit);

        return "redirect:";
    }
}







