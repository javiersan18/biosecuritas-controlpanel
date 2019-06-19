package com.biosecuritas.controlpanel.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.biosecuritas.controlpanel.db.entities.Client;
import com.biosecuritas.controlpanel.db.entities.Installation;
import com.biosecuritas.controlpanel.db.repositories.ClientRepository;
import com.biosecuritas.controlpanel.db.repositories.FarmRepository;
import com.biosecuritas.controlpanel.db.repositories.HydrolyzerRepository;
import com.biosecuritas.controlpanel.db.repositories.InstallationRepository;

@Controller
public class InstallationController {

	private static final Logger log = LogManager.getLogger(InstallationController.class);

	@Autowired
	private InstallationRepository installationRepository;

	@Autowired
	private HydrolyzerRepository hydrolyzerRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private FarmRepository farmRepository;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@GetMapping(path = "/installations")
	public String getAllInstallations(@RequestParam(required = false) String status, Model model) {
		List<Installation> installs = installationRepository.findAll();
		model.addAttribute("installations", installs);
		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("farms", farmRepository.findAll());
		model.addAttribute("hydros", hydrolyzerRepository.findAll());
		model.addAttribute("newInstall", new Installation());
		model.addAttribute("editInstall", new Installation());
		if (status == null && installs.isEmpty()) {
			status = "empty";
		}
		model.addAttribute("status", status);
		return "/installations/installations";
	}

	@PostMapping("/add-install")
	public String addInstall(@ModelAttribute("newInstall") @Valid Installation install, BindingResult result,
			Model model) {

		model.addAttribute("installations", installationRepository.findAll());
		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("farms", farmRepository.findAll());
		model.addAttribute("hydros", hydrolyzerRepository.findAll());
		model.addAttribute("newInstall", new Installation());
		model.addAttribute("editInstall", new Installation());
		model.addAttribute("status", "created");

		if (result.hasErrors()) {
			model.addAttribute("newInstall", install);
			model.addAttribute("status", "error");
			model.addAttribute("errorDesc", "errorDesc");
			log.error(result.toString());
			return "/installations/installations";
		}

		installationRepository.save(install);
		return "redirect:/installations";
	}

	@GetMapping("/edit-install/{id}")
	public String editInstall(@PathVariable("id") Integer id, @Valid Installation install, BindingResult result,
			Model model) {

		model.addAttribute("installations", installationRepository.findAll());
		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("farms", farmRepository.findAll());
		model.addAttribute("hydros", hydrolyzerRepository.findAll());
		model.addAttribute("newInstall", new Installation());
		model.addAttribute("editInstall", installationRepository.findById(id));
		model.addAttribute("status", "edit");

		if (result.hasErrors()) {
			model.addAttribute("editInstall", install);
			model.addAttribute("status", "error");
			model.addAttribute("errorDesc", "errorDesc");
			log.error(result.toString());
			return "/installations/installations";
		}

		return "/installations/installations";
	}

	@GetMapping("/view-install/{id}")
	public String viewInstall(@PathVariable("id") Integer id, @Valid Installation install, BindingResult result,
			Model model) {

		model.addAttribute("installations", installationRepository.findAll());
		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("farms", farmRepository.findAll());
		model.addAttribute("hydros", hydrolyzerRepository.findAll());
		model.addAttribute("newInstall", new Installation());
		model.addAttribute("editInstall", installationRepository.findById(id));
		model.addAttribute("status", "view");

		if (result.hasErrors()) {
			model.addAttribute("editInstall", install);
			model.addAttribute("status", "error");
			model.addAttribute("errorDesc", "errorDesc");
			log.error(result.toString());
			return "/installations/installations";
		}

		return "/installations/installations";
	}

	@PostMapping("/update-install")
	public String updateFarm(@Valid Installation install, BindingResult result, Model model) {

		model.addAttribute("installations", installationRepository.findAll());
		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("farms", farmRepository.findAll());
		model.addAttribute("hydros", hydrolyzerRepository.findAll());
		model.addAttribute("newInstall", new Installation());
		model.addAttribute("editInstall", new Installation());
		model.addAttribute("status", "updated");

		if (result.hasErrors()) {
			model.addAttribute("editInstall", install);
			model.addAttribute("status", "error");
			model.addAttribute("errorDesc", "errorDesc");
			log.error(result.toString());
			return "/installations/installations";
		}

		installationRepository.save(install);
		return "redirect:/installations";
	}

	@GetMapping("/delete-install/{id}")
	public String deleteInstall(@PathVariable("id") Integer id, Model model) {
		Installation install = installationRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid install Id:" + id));

		try {
			installationRepository.delete(install);
			model.addAttribute("installations", installationRepository.findAll());
			model.addAttribute("clients", clientRepository.findAll());
			model.addAttribute("farms", farmRepository.findAll());
			model.addAttribute("hydros", hydrolyzerRepository.findAll());
			model.addAttribute("newInstall", new Installation());
			model.addAttribute("editInstall", new Installation());
			model.addAttribute("status", "deleted");
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("status", "error");
			model.addAttribute("errorDesc",
					"fixxxxxx: No se ha podido borrar el cliente porque existen Granjas o Contenedores asociados a este cliente.");
		}

		return "redirect:/installations";
	}

	// additional CRUD methods
}
