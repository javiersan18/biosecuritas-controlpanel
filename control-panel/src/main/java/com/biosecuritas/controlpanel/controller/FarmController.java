package com.biosecuritas.controlpanel.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
	public String getAllFarms(@RequestParam(required = false) String status,
			@RequestParam(required = false) String errorDesc, Model model) {
		List<Farm> farms = farmRepository.findAll();
		model.addAttribute("farms", farms);
		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("newFarm", new Farm());
		model.addAttribute("editFarm", new Farm());
		if (status == null && farms.isEmpty()) {
			status = "empty";
		}
		model.addAttribute("status", status);
		model.addAttribute("errorDesc", errorDesc);
		return "farms/farms";
	}

	@PostMapping("/add-farm")
	public String addFarm(@ModelAttribute("newFarm") @Valid Farm farm, BindingResult result, Model model) {

		model.addAttribute("farms", farmRepository.findAll());
		model.addAttribute("status", "created");
		model.addAttribute("newFarm", new Farm());
		model.addAttribute("editFarm", new Farm());

		if (result.hasErrors()) {
			model.addAttribute("newFarm", farm);
			model.addAttribute("status", "error");
			model.addAttribute("errorDesc", "errorDesc");
			log.error(result.toString());
			return "farms/farms";
		}

		farmRepository.save(farm);
		return "redirect:/farms";
	}

	@GetMapping("/edit-farm/{id}")
	public String editFarm(@PathVariable("id") Integer id, @Valid Farm farm, BindingResult result, Model model) {

		model.addAttribute("farms", farmRepository.findAll());
		model.addAttribute("newFarm", new Farm());
		model.addAttribute("editFarm", farmRepository.findById(id));
		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("status", "edit");

		if (result.hasErrors()) {
			model.addAttribute("newFarm", farm);
			model.addAttribute("editFarm", new Farm());
			model.addAttribute("status", "error");
			model.addAttribute("errorDesc", "errorDesc");
			log.error(result.toString());
			return "farms/farms";
		}

		return "farms/farms";
	}

	@GetMapping("/view-farm/{id}")
	public String viewFarm(@PathVariable("id") Integer id, @Valid Farm farm, BindingResult result, Model model) {

		model.addAttribute("farms", farmRepository.findAll());
		model.addAttribute("newFarm", new Farm());
		model.addAttribute("editFarm", farmRepository.findById(id));
		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("status", "view");

		if (result.hasErrors()) {
			model.addAttribute("newFarm", farm);
			model.addAttribute("status", "error");
			model.addAttribute("errorDesc", "errorDesc");
			log.error(result.toString());
			return "farms/farms";
		}

		return "farms/farms";
	}

	@PostMapping("/update-farm")
	public String updateFarm(@Valid Farm farm, BindingResult result, Model model) {

		model.addAttribute("farms", farmRepository.findAll());
		model.addAttribute("newFarm", new Farm());
		model.addAttribute("editFarm", new Farm());
		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("status", "updated");

		if (result.hasErrors()) {
			model.addAttribute("newFarm", farm);
			model.addAttribute("status", "error");
			model.addAttribute("errorDesc", "errorDesc");
			log.error(result.toString());
			return "farms/farms";
		}

		farmRepository.save(farm);
		return "redirect:/farms";
	}

	@GetMapping("/delete-farm/{id}")
	public String deleteFarm(@PathVariable("id") Integer id, Model model) {
		Farm farm = farmRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid farm Id:" + id));
		try {
			farmRepository.delete(farm);
			model.addAttribute("farm", farmRepository.findAll());
			model.addAttribute("newFarm", new Farm());
			model.addAttribute("editFarm", new Farm());
			model.addAttribute("clients", clientRepository.findAll());
			model.addAttribute("status", "deleted");
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("status", "error");
			model.addAttribute("errorDesc",
					"fixxxxxx: No se ha podido borrar el cliente porque existen Granjas o Contenedores asociados a este cliente.");
		}
		return "redirect:/farms";
	}

	// additional CRUD methods
}
