package com.biosecuritas.controlpanel.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

	private static final Logger log = LogManager.getLogger(DashboardController.class);

	@GetMapping("/dashboard")
	public String dashboard() {
		// log.info(authentication.toString());
		return "dashboard";
	}
}
