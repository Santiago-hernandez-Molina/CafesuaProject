package com.usta.cafesua.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.usta.cafesua.entities.Place;
import com.usta.cafesua.models.services.IPlace;

@Controller
public class PlaceController {
	
	@Autowired
	private IPlace iPlaceService;
	
	@GetMapping("/listPlace")
	public String list(Model model) {
		model.addAttribute("title", "list Places");
		model.addAttribute("place", iPlaceService.findAll());
		
		return "listPlace";
	}
	
	@GetMapping(value = "/placeForm")
	public String addPlace(Model model) {
		model.addAttribute("place", new Place());
		return "placeForm";
	}
	
	@PostMapping(value="/placeForm")
	public String savePlace(@Valid Place place, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "placeForm";
		}
		iPlaceService.savePlace(place);
		return "redirect:/";
	}
}
