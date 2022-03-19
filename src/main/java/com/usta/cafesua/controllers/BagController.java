package com.usta.cafesua.controllers;

import com.usta.cafesua.entities.Bag;
import com.usta.cafesua.models.services.IBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class BagController {

    @Autowired
    private IBag iBagService;

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

    @RequestMapping("/deleteBag/{id}")
    public String delete(@PathVariable(value = "id") Long id, RedirectAttributes flash){

        if (id>0){
            iBagService.deleteByBagId(id);
            flash.addFlashAttribute("sucess","Delete bag successfully");
        }
        return "redirect:/listBag";
    }


}
