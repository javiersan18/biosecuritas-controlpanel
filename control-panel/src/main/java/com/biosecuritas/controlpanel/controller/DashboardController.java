package com.biosecuritas.controlpanel.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

	private static final Logger log = LogManager.getLogger(DashboardController.class);

	@RequestMapping("/dashboard")
	public String dashboard() {
		//log.info(authentication.toString());
		return "dashboard";
	}
}
