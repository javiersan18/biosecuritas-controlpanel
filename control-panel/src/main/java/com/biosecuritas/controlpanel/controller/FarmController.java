package com.biosecuritas.controlpanel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.biosecuritas.controlpanel.db.entities.Farm;
import com.biosecuritas.controlpanel.db.repositories.FarmRepository;

@Controller
public class FarmController {

	@Autowired
	private FarmRepository farmRepository;

	@GetMapping(path = "/farms")
	public String getAllFarms(Model model) {
		model.addAttribute("farms", farmRepository.findAll());
		return "farms";
	}

	@PostMapping("/add-farm")
	public String addFarm(@Valid Farm farm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-farm";
		}

		farmRepository.save(farm);
		model.addAttribute("farm", farmRepository.findAll());
		return "farms";
	}

	@PostMapping("/update-farm/{id}")
	public String updateFarm(@PathVariable("id") Integer id, @Valid Farm farm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// client.setId(id);
			return "update-farm";
		}

		farmRepository.save(farm);
		model.addAttribute("farm", farmRepository.findAll());
		return "farms";
	}

	@GetMapping("/delete-farm/{id}")
	public String deleteFarm(@PathVariable("id") Integer id, Model model) {
		Farm farm = farmRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid farm Id:" + id));
		farmRepository.delete(farm);
		model.addAttribute("farm", farmRepository.findAll());
		return "farms";
	}

	// additional CRUD methods
}
