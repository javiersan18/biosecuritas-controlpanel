package com.biosecuritas.controlpanel.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.biosecuritas.controlpanel.db.entities.Installation;
import com.biosecuritas.controlpanel.db.repositories.InstallationRepository;
import com.biosecuritas.controlpanel.utils.InstallationStatus;

@Controller
public class RoutesController {

	private static final Logger log = LogManager.getLogger(RoutesController.class);

	@Autowired
	private InstallationRepository installationRepository;

	@GetMapping(path = "/routes")
	public String showMap(Model model) {
		model.addAttribute("installations", installationRepository.findByStatus(InstallationStatus.SEALED));
		model.addAttribute("editInstall", new Installation());
		return "routes/prepare";
	}

	@GetMapping("/view-install-routes/{id}")
	public String viewInstallRoutes(@PathVariable("id") Integer id, @Valid Installation install, BindingResult result,
			Model model) {

		model.addAttribute("installations", installationRepository.findByStatus(InstallationStatus.SEALED));
		model.addAttribute("editInstall", installationRepository.findById(id));
		model.addAttribute("status", "view");

		if (result.hasErrors()) {
			model.addAttribute("editInstall", install);
			model.addAttribute("status", "error");
			model.addAttribute("errorDesc", "errorDesc");
			log.error(result.toString());
			return "/installations/installations";
		}

		return "routes/prepare";
	}

}
