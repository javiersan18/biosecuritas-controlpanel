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

import com.biosecuritas.controlpanel.db.entities.Hydrolyzer;
import com.biosecuritas.controlpanel.db.repositories.FarmRepository;
import com.biosecuritas.controlpanel.db.repositories.HydrolyzerRepository;

@Controller
public class HydrolyzerController {

	private static final Logger log = LogManager.getLogger(HydrolyzerController.class);

	@Autowired
	private HydrolyzerRepository hydrolyzerRepository;

	@Autowired
	private FarmRepository farmRepository;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@GetMapping(path = "/hydrolyzers")
	public String getAllHydrolyzers(@RequestParam(required = false) String status,
			@RequestParam(required = false) String errorDesc, Model model) {
		List<Hydrolyzer> hydros = hydrolyzerRepository.findAll();
		model.addAttribute("hydros", hydros);
		model.addAttribute("farms", farmRepository.findAll());
		model.addAttribute("newHydro", new Hydrolyzer());
		model.addAttribute("editHydro", new Hydrolyzer());
		if (status == null && hydros.isEmpty()) {
			status = "empty";
		}
		model.addAttribute("status", status);
		model.addAttribute("errorDesc", errorDesc);

		return "hydrolyzers/hydrolyzers";
	}

	@PostMapping("/add-hydro")
	public String addHydro(@ModelAttribute("newHydro") @Valid Hydrolyzer hydro, BindingResult result, Model model) {
		model.addAttribute("hydros", hydrolyzerRepository.findAll());
		model.addAttribute("newHydro", new Hydrolyzer());
		model.addAttribute("editHydro", new Hydrolyzer());
		model.addAttribute("status", "created");

		if (result.hasErrors()) {
			model.addAttribute("newHydro", hydro);
			model.addAttribute("status", "error");
			model.addAttribute("errorDesc", "errordesc");
			log.error(result.toString());
			return "hydrolyzers/hydrolyzers";
		}

		hydrolyzerRepository.save(hydro);
		return "redirect:/hydrolyzers";
	}

	@GetMapping("/edit-hydro/{id}")
	public String editHydro(@PathVariable("id") Integer id, @Valid Hydrolyzer hydro, BindingResult result,
			Model model) {
		model.addAttribute("hydros", hydrolyzerRepository.findAll());
		model.addAttribute("newHydro", new Hydrolyzer());
		model.addAttribute("editHydro", hydrolyzerRepository.findById(id));
		model.addAttribute("farms", farmRepository.findAll());
		model.addAttribute("status", "edit");

		if (result.hasErrors()) {
			model.addAttribute("editHydro", hydro);
			model.addAttribute("status", "error");
			model.addAttribute("errorDesc", "errorDesc");
			log.error(result.toString());
			return "hydrolyzers/hydrolyzers";
		}

		return "hydrolyzers/hydrolyzers";
	}

	@GetMapping("/view-hydro/{id}")
	public String viewHydro(@PathVariable("id") Integer id, @Valid Hydrolyzer hydro, BindingResult result,
			Model model) {
		model.addAttribute("hydros", hydrolyzerRepository.findAll());
		model.addAttribute("newHydro", new Hydrolyzer());
		model.addAttribute("editHydro", hydrolyzerRepository.findById(id));
		model.addAttribute("farms", farmRepository.findAll());
		model.addAttribute("status", "view");

		if (result.hasErrors()) {
			model.addAttribute("newHydro", hydro);
			model.addAttribute("editHydro", new Hydrolyzer());
			model.addAttribute("status", "error");
			model.addAttribute("erorDesc", "errordesc");
			log.error(result.toString());
			return "hydrolyzers/hydrolyzers";
		}

		return "hydrolyzers/hydrolyzers";
	}

	@PostMapping("/update-hydro")
	public String updateFarm(@Valid Hydrolyzer hydro, BindingResult result, Model model) {
		model.addAttribute("hydros", hydrolyzerRepository.findAll());
		model.addAttribute("newHydro", new Hydrolyzer());
		model.addAttribute("editHydro", new Hydrolyzer());
		model.addAttribute("farms", farmRepository.findAll());
		model.addAttribute("status", "updated");

		if (result.hasErrors()) {
			model.addAttribute("editHydro", hydro);
			model.addAttribute("status", "error");
			model.addAttribute("errorDesc", "errordesc");
			log.error(result.toString());
			return "hydrolyzers/hydrolyzers";
		}

		hydrolyzerRepository.save(hydro);
		return "redirect:/hydrolyzers";
	}

	@GetMapping("/delete-hydro/{id}")
	public String deleteHydro(@PathVariable("id") Integer id, Model model) {
		Hydrolyzer hydro = hydrolyzerRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Hydro Id:" + id));
		try {
			hydrolyzerRepository.delete(hydro);
			model.addAttribute("hydros", hydrolyzerRepository.findAll());
			model.addAttribute("newHydro", new Hydrolyzer());
			model.addAttribute("editHydro", new Hydrolyzer());
			model.addAttribute("farms", farmRepository.findAll());
			model.addAttribute("status", "deleted");
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("status", "error");
			model.addAttribute("errorDesc",
					"fixxxxxx: No se ha podido borrar el cliente porque existen Granjas o Contenedores asociados a este cliente.");
		}
		return "redirect:/hydrolyzers";
	}

// additional CRUD methods
}
