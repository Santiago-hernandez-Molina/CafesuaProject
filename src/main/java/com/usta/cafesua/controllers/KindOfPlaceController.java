package com.usta.cafesua.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.usta.cafesua.entities.KindOfPlace;
import com.usta.cafesua.models.services.IKindOfPlace;

@Controller
public class KindOfPlaceController {
	@Autowired
	private IKindOfPlace iKindOfPlaceService;
	
	@GetMapping("/listKindOfPlace")
	public String list(Model model) {
		model.addAttribute("kindOfPlace", iKindOfPlaceService.findAll());
		
		return "listKindOfPlace";
	}
	
	@GetMapping(value = "/kindOfPlaceForm")
	public String addKindOfPlace(Model model) {
		model.addAttribute("kindOfPlace", new KindOfPlace());
		
		return "kindOfPlaceForm";
	}
	
	@PostMapping(value = "/kindOfPlaceForm")
	public String saveKindOfPlace(@Valid KindOfPlace kindOfPlace, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "kindOfPlaceForm";
		}
		
		iKindOfPlaceService.saveKindOfPlace(kindOfPlace);
		return "redirect:/";
	}
}
