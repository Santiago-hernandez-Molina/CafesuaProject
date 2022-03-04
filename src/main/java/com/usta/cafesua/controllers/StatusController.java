package com.usta.cafesua.controllers;


import com.usta.cafesua.models.services.IStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatusController {

    @Autowired
    private IStatus iStatusService;

    @GetMapping("/listStatus")
    public String list(Model model){
        model.addAttribute("titulo","List Status");
        model.addAttribute("Status",iStatusService.findAll());
        return "listStatus";
    }
}
