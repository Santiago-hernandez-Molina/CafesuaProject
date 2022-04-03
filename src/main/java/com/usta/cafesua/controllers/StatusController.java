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

import com.usta.cafesua.entities.Status;
import com.usta.cafesua.models.services.IStatus;

@Controller
public class StatusController {

    @Autowired
    private IStatus iStatusService;

    @GetMapping(value = "/statusTemplate")
    public String addStatus(Model model) {
        model.addAttribute("status", new Status());
        
        return "statusForm";
    }

    @PostMapping(value = "/statusTemplate")
    public String saveStatus(@Valid Status status, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "statusForm";
        }
        
        iStatusService.saveStatus(status);
        return "redirect:/";
    }

	@PostMapping(value="/statusTemplate/{id}")
    public String updateStatus(@PathVariable(value="id") Long id, @Valid Status status, BindingResult result, Model model) {
		if (iStatusService.findById(id) != null) {
			status.setId(id);
	    	iStatusService.saveStatus(status);
	    	
	    	return "redirect:/";
		} else {
			return "statusForm";
		}
	}
	
	@RequestMapping(value="/deleteStatus/{id}")
    public String deleteStatus(@PathVariable(value ="id") Long id, RedirectAttributes flash){

        if (id > 0){
            iStatusService.deleteStatus(id);
            flash.addFlashAttribute("success","status eliminated properly");
        }
        return "redirect:/";
    }
}
