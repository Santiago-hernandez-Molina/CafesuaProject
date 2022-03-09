package com.usta.cafesua.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.usta.cafesua.models.services.IKindOfPlace;

@Controller
public class KindOfPlaceController {
	@Autowired
	private IKindOfPlace iKindOfPlaceService;
	
	@GetMapping("/listKindOfPlace")
	public String list(Model model) {
		model.addAttribute("title", "list KindOfPlaces");
		model.addAttribute("kindOfPlaces", iKindOfPlaceService.findAll());
		
		return "listKindOfPlace";
	}
}
