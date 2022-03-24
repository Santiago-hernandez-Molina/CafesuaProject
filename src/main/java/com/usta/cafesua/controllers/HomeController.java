package com.usta.cafesua.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.usta.cafesua.models.services.IKindOfPlace;
import com.usta.cafesua.models.services.IPlace;
import com.usta.cafesua.models.services.IStatus;

@Controller
public class HomeController {
	@Autowired
	private IStatus iStatusService;
	
	@Autowired
	private IPlace iPlaceService;
	
	@Autowired
	private IKindOfPlace iKindOfPlaceService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("statusList", iStatusService.findAll());
		model.addAttribute("placeList", iPlaceService.findAll());
		model.addAttribute("kindOfPlaceList", iKindOfPlaceService.findAll());
		return "/fragments/content";
	}
}
