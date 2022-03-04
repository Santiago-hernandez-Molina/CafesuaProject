package com.usta.cafesua.controllers;

import com.usta.cafesua.models.services.IBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BagController {

    @Autowired
    private IBag iBagService;

    @GetMapping("/listBag")
    public String list(Model model) {
        model.addAttribute("actual_weight", "list Bags");
        model.addAttribute("bags", iBagService.findAll());
        return "listBag";
    }

}
