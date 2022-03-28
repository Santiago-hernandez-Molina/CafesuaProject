package com.usta.cafesua.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.usta.cafesua.entities.Status;
import com.usta.cafesua.models.services.IStatus;

@Controller
public class StatusController {

    @Autowired
    private IStatus iStatusService;

    @GetMapping("/statusList")
    public String list(Model model){
        return "statusList";
    }

    @GetMapping(value = "/statusForm")
    public String addStatus(Model model) {
        model.addAttribute("status", new Status());
        return "createStatus";
    }

    @PostMapping(value = "/statusForm")
    public String saveStatus(@Valid Status status, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "statusForm";
        }
        iStatusService.saveStatus(status);
        return "redirect:/";
    }
}
