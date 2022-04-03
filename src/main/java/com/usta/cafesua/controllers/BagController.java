package com.usta.cafesua.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usta.cafesua.entities.Bag;
import com.usta.cafesua.models.services.IBag;

@Controller
public class BagController {
	@Autowired
	private IBag iBagService;

	@GetMapping("/bagList")
	public String list(Model model) {
		return "bagList";
	}

	@GetMapping(value = "/bagTemplate")
	public String addBag(Model model) {
		model.addAttribute("bag", new Bag());
		return "bagForm";
	}

	@PostMapping(value = "/bagTemplate")
	public String saveBag(@Valid Bag bag, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "bagForm";
		}
		iBagService.saveBag(bag);
		return "redirect:/";
	}

	@PostMapping(value="/bagTemplate/{id}")
    public String updateBag(@PathVariable(value="id") Long id, @Valid Bag bag, BindingResult result, Model model) {
		if (iBagService.findById(id) != null) {
			bag.setId(id);
	    	iBagService.saveBag(bag);
	    	
	    	return "redirect:/";
		} else {
			return "bagForm";
		}
	}

	@RequestMapping(value="/deleteBag/{id}")
    public String deleteBag(@PathVariable(value ="id") Long id , RedirectAttributes flash){

        if (id>0){
            iBagService.deleteBag(id);
            flash.addFlashAttribute("succes","bag eliminated properly");
        }
        return "redirect:/";
    }
}
