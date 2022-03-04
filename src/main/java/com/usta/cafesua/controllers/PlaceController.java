package com.usta.cafesua.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.usta.cafesua.models.services.IPlace;

@Controller
public class PlaceController {
	
	@Autowired
	private IPlace iPlaceService;
	
	@GetMapping("/listPlace")
	public String list(Model model) {
		model.addAttribute("title", "list Places");
		model.addAttribute("places", iPlaceService.findAll());
		return "listPlace";
	}
}
