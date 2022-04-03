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

import com.usta.cafesua.entities.KindOfPlace;
import com.usta.cafesua.models.services.IKindOfPlace;

@Controller
public class KindOfPlaceController {
	
	@Autowired
	private IKindOfPlace iKindOfPlaceService;
	
	@GetMapping(value = "/kindOfPlaceTemplate")
	public String addKindOfPlace(Model model) {
		model.addAttribute("kindOfPlace", new KindOfPlace());
		
		return "kindOfPlaceForm";
	}
	
	@PostMapping(value = "/kindOfPlaceTemplate")
	public String saveKindOfPlace(@Valid KindOfPlace kindOfPlace, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "kindOfPlaceForm";
		}
		
		iKindOfPlaceService.saveKindOfPlace(kindOfPlace);
		return "redirect:/";
	}

	@PostMapping(value="/kindOfPlaceTemplate/{id}")
    public String updateKindOfPlace(@PathVariable(value="id") Long id, @Valid KindOfPlace kindOfPlace, BindingResult result, Model model) {
		if (iKindOfPlaceService.findById(id) != null) {
			kindOfPlace.setId(id);
	    	iKindOfPlaceService.saveKindOfPlace(kindOfPlace);
	    	
	    	return "redirect:/";
		} else {
			return "kindOfPlaceForm";
		}
	}
	
	@RequestMapping(value="/deleteKindOfPlace/{id}")
    public String deleteKindOfPlace(@PathVariable(value ="id") Long id, RedirectAttributes flash){

        if (id > 0){
            iKindOfPlaceService.deleteKindOfPlace(id);
            flash.addFlashAttribute("success","Kind Of Place eliminated properly");
        }
        return "redirect:/";
    }
}
