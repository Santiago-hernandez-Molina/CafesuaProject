package com.usta.cafesua.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.usta.cafesua.entities.Status;
import com.usta.cafesua.models.services.IStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StatusController {

    @Autowired
    private IStatus iStatusService;

    @GetMapping("/listStatus")
    public String list(Model model) {
        model.addAttribute("title", "List Status");
        model.addAttribute("status", iStatusService.findAll());
        return "listStatus";
    }

    @GetMapping(value = "/createStatus")
    public String addStatus(Model model) {
        model.addAttribute("status", new Status());
        model.addAttribute("title", "Create Status");
        return "createStatus";
    }

    @PostMapping(value = "/createStatus")
    public String saveStatus(@Valid Status status, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "createStatus";
        }
        iStatusService.saveStatus(status);
        return "redirect:/listStatus";
    }

    @RequestMapping("/deleteStatus/{id}")
    public String delete(@PathVariable(value = "id") Long id, RedirectAttributes flash){

        if (id>0){
            iStatusService.deleteByIdStatus(id);
            flash.addFlashAttribute("sucess","Delete bag successfully");
        }
        return "redirect:/listStatus";
    }
}
