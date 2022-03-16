package com.usta.cafesua.controllers;

import com.usta.cafesua.entities.Bag;
import com.usta.cafesua.models.dao.IPlaceDao;
import com.usta.cafesua.models.services.IBag;
import com.usta.cafesua.models.services.IPlace;
import com.usta.cafesua.models.services.IStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class BagController {

    @Autowired
    private IBag iBagService;
    @Autowired
    private IPlace iPlaceService;
    @Autowired
    private IStatus iStatusService;

    @GetMapping("/listBag")
    public String list(Model model) {
        model.addAttribute("title", "list Bags");
        model.addAttribute("bags", iBagService.findAll());
        return "listBag";
    }

    @GetMapping(value = "/createBag")
    public String addBag(Model model) {
        model.addAttribute("bag", new Bag());
        model.addAttribute("title", "Create Bag");
        model.addAttribute("places", iPlaceService.findAll());
        model.addAttribute("status", iStatusService.findAll());
        return "createBag";
    }

    @PostMapping(value = "/createBag")
    public String saveBag(@Valid Bag bag, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "createBag";
        }
        iBagService.saveBag(bag);
        return "redirect:/listBag";
    }

}
