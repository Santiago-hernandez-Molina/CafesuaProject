package com.usta.cafesua.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.usta.cafesua.models.services.IBag;
import com.usta.cafesua.models.services.IKindOfPlace;
import com.usta.cafesua.models.services.IPlace;
import com.usta.cafesua.models.services.IStatus;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index(Model model) {
		return "/home";
	}
}
