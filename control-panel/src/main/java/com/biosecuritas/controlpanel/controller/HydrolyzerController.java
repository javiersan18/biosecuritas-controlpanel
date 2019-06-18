package com.biosecuritas.controlpanel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.biosecuritas.controlpanel.db.entities.Hydrolyzer;
import com.biosecuritas.controlpanel.db.repositories.ClientRepository;
import com.biosecuritas.controlpanel.db.repositories.HydrolyzerRepository;

@Controller
public class HydrolyzerController {

	@Autowired
	private HydrolyzerRepository hydrolyzerRepository;

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping(path = "/hydrolyzers")
	public String getAllHydrolyzers(@RequestParam(required = false) String status, Model model) {
		List<Hydrolyzer> hydros = hydrolyzerRepository.findAll();
		model.addAttribute("hydros", hydros);
		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("newHydro", new Hydrolyzer());
		model.addAttribute("editHydro", new Hydrolyzer());
		if (status == null && hydros.isEmpty()) {
			status = "empty";
		}
		model.addAttribute("status", status);
		return "/hydrolyzers/hydrolyzers";
	}

	/*
	 * @PostMapping("/add-farm") public String
	 * addFarm(@ModelAttribute("newFarm") @Valid Farm farm, BindingResult result,
	 * Model model) { if (result.hasErrors()) { model.addAttribute("farms",
	 * farmRepository.findAll()); model.addAttribute("newFarm", farm);
	 * model.addAttribute("errors", "ko"); return "/farms/farms"; }
	 * 
	 * farmRepository.save(farm); model.addAttribute("farms",
	 * farmRepository.findAll()); model.addAttribute("status", "created");
	 * model.addAttribute("newFarm", new Farm()); model.addAttribute("editFarm", new
	 * Farm()); return "redirect:/farms"; }
	 * 
	 * @GetMapping("/edit-farm/{id}") public String editFarm(@PathVariable("id")
	 * Integer id, @Valid Farm farm, BindingResult result, Model model) { if
	 * (result.hasErrors()) { // client.setId(id); return "update-farm"; }
	 * 
	 * model.addAttribute("farms", farmRepository.findAll());
	 * model.addAttribute("newFarm", new Farm()); model.addAttribute("editFarm",
	 * farmRepository.findById(id)); model.addAttribute("clients",
	 * clientRepository.findAll()); model.addAttribute("status", "edit"); return
	 * "/farms/farms"; }
	 * 
	 * @GetMapping("/view-farm/{id}") public String viewFarm(@PathVariable("id")
	 * Integer id, @Valid Farm farm, BindingResult result, Model model) { if
	 * (result.hasErrors()) { // client.setId(id); return "update-farm"; }
	 * 
	 * model.addAttribute("farms", farmRepository.findAll());
	 * model.addAttribute("newFarm", new Farm()); model.addAttribute("editFarm",
	 * farmRepository.findById(id)); model.addAttribute("clients",
	 * clientRepository.findAll()); model.addAttribute("status", "view"); return
	 * "/farms/farms"; }
	 * 
	 * @PostMapping("/update-farm") public String updateFarm(@Valid Farm farm,
	 * BindingResult result, Model model) { if (result.hasErrors()) { //
	 * client.setId(id); return "update-farm"; }
	 * 
	 * farmRepository.save(farm); model.addAttribute("farms",
	 * farmRepository.findAll()); model.addAttribute("newFarm", new Farm());
	 * model.addAttribute("editFarm", new Farm()); model.addAttribute("clients",
	 * clientRepository.findAll()); model.addAttribute("status", "updated"); return
	 * "redirect:/farms"; }
	 * 
	 * @GetMapping("/delete-farm/{id}") public String deleteFarm(@PathVariable("id")
	 * Integer id, Model model) { Farm farm = farmRepository.findById(id)
	 * .orElseThrow(() -> new IllegalArgumentException("Invalid farm Id:" + id));
	 * farmRepository.delete(farm); model.addAttribute("farm",
	 * farmRepository.findAll()); model.addAttribute("newFarm", new Farm());
	 * model.addAttribute("editFarm", new Farm()); model.addAttribute("clients",
	 * clientRepository.findAll()); model.addAttribute("status", "deleted"); return
	 * "redirect:/farms"; }
	 */
	// additional CRUD methods
}
