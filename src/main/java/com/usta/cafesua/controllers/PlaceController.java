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

import com.usta.cafesua.entities.Place;
import com.usta.cafesua.models.services.IPlace;

@Controller
public class PlaceController {
	
	@Autowired
	private IPlace iPlaceService;
	
	@GetMapping("/listPlace")
	public String list(Model model) {
		return "listPlace";
	}
	
	@GetMapping(value = "/placeTemplate")
	public String addPlace(Model model) {
		model.addAttribute("place", new Place());
		return "placeForm";
	}
	
	@PostMapping(value="/placeTemplate")
	public String savePlace(@Valid Place place, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "placeForm";
		}
		iPlaceService.savePlace(place);
		return "redirect:/";
	}

	@PostMapping(value="/placeTemplate/{id}")
    public String updatePlace(@PathVariable(value="id") Long id, @Valid Place place, BindingResult result, Model model) {
		if (iPlaceService.findById(id) != null) {
			place.setId(id);
	    	iPlaceService.savePlace(place);
	    	
	    	return "redirect:/";
		} else {
			return "palceForm";
		}
	}
	
	@RequestMapping(value="/deletePlace/{id}")
    public String deleteBag(@PathVariable(value ="id") Long id , RedirectAttributes flash){

        if (id > 0){
            iPlaceService.deletePlace(id);
            flash.addFlashAttribute("success","place eliminated properly");
        }
        return "redirect:/";
    }
}
