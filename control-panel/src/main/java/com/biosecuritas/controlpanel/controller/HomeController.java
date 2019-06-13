package com.biosecuritas.controlpanel.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private static final Logger log = LogManager.getLogger(HomeController.class);

	@RequestMapping("/")
	public String index() {
		return "home";
	}

	@GetMapping("/home")
	public String dashboard() {
		// log.info(authentication.toString());
		return "home";
	}

}
