package com.usta.cafesua.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.usta.cafesua.entities.Bag;
import com.usta.cafesua.models.services.IBag;

@Controller
public class BagController {

    @Autowired
    private IBag iBagService;

    @GetMapping("/bagList")
    public String list(Model model) {
        model.addAttribute("bags", iBagService.findAll());
        return "bagList";
    }

    @GetMapping(value = "/bagForm")
    public String addBag(Model model) {
        model.addAttribute("bag", new Bag());
        return "bagForm";
    }

    @PostMapping(value = "/bagForm")
    public String saveBag(@Valid Bag bag, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "bagForm";
        }
        iBagService.saveBag(bag);
        return "redirect:/";
    }

}
