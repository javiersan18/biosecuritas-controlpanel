package com.biosecuritas.controlpanel.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.biosecuritas.controlpanel.db.entities.Farm;
import com.biosecuritas.controlpanel.db.repositories.ClientRepository;
import com.biosecuritas.controlpanel.db.repositories.FarmRepository;

@Controller
public class FarmController {

	private static final Logger log = LogManager.getLogger(FarmController.class);

	@Autowired
	private FarmRepository farmRepository;

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping(path = "/farms")
	public String getAllFarms(@RequestParam(required = false) String status, Model model) {
		model.addAttribute("farms", farmRepository.findAll());
		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("newFarm", new Farm());
		model.addAttribute("editFarm", new Farm());
		model.addAttribute("status", status);
		return "/farms/farms";
	}

	@PostMapping("/add-farm")
	public String addFarm(@ModelAttribute("newFarm") @Valid Farm farm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("farms", farmRepository.findAll());
			model.addAttribute("newFarm", farm);
			model.addAttribute("editFarm", new Farm());
			model.addAttribute("errors", "error");
			log.error(result.toString());
			return "/farms/farms";
		}

		farmRepository.save(farm);
		model.addAttribute("farms", farmRepository.findAll());
		model.addAttribute("status", "created");
		model.addAttribute("newFarm", new Farm());
		model.addAttribute("editFarm", new Farm());
		return "redirect:/farms";
	}

	@GetMapping("/edit-farm/{id}")
	public String editFarm(@PathVariable("id") Integer id, @Valid Farm farm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("farms", farmRepository.findAll());
			model.addAttribute("newFarm", farm);
			model.addAttribute("editFarm", new Farm());
			model.addAttribute("errors", "error");
			log.error(result.toString());
			return "/farms/farms";
		}

		model.addAttribute("farms", farmRepository.findAll());
		model.addAttribute("newFarm", new Farm());
		model.addAttribute("editFarm", farmRepository.findById(id));
		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("status", "edit");
		return "/farms/farms";
	}

	@GetMapping("/view-farm/{id}")
	public String viewFarm(@PathVariable("id") Integer id, @Valid Farm farm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("farms", farmRepository.findAll());
			model.addAttribute("newFarm", farm);
			model.addAttribute("editFarm", new Farm());
			model.addAttribute("errors", "error");
			log.error(result.toString());
			return "/farms/farms";
		}

		model.addAttribute("farms", farmRepository.findAll());
		model.addAttribute("newFarm", new Farm());
		model.addAttribute("editFarm", farmRepository.findById(id));
		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("status", "view");
		return "/farms/farms";
	}

	@PostMapping("/update-farm")
	public String updateFarm(@Valid Farm farm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("farms", farmRepository.findAll());
			model.addAttribute("newFarm", farm);
			model.addAttribute("editFarm", new Farm());
			model.addAttribute("errors", "error");
			log.error(result.toString());
			return "/farms/farms";
		}

		farmRepository.save(farm);
		model.addAttribute("farms", farmRepository.findAll());
		model.addAttribute("newFarm", new Farm());
		model.addAttribute("editFarm", new Farm());
		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("status", "updated");
		return "redirect:/farms";
	}

	@GetMapping("/delete-farm/{id}")
	public String deleteFarm(@PathVariable("id") Integer id, Model model) {
		Farm farm = farmRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid farm Id:" + id));
		farmRepository.delete(farm);
		model.addAttribute("farm", farmRepository.findAll());
		model.addAttribute("newFarm", new Farm());
		model.addAttribute("editFarm", new Farm());
		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("status", "deleted");
		return "redirect:/farms";
	}

	// additional CRUD methods
}
