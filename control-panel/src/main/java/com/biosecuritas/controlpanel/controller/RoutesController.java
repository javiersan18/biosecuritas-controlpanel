package com.biosecuritas.controlpanel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoutesController {

	@GetMapping(path = "/routes")
	public String showMap(Model model) {
		// model.addAttribute("farms", farmRepository.findAll());
		return "routes";
	}

}
