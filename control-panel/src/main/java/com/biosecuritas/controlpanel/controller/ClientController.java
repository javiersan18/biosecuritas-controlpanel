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

import com.biosecuritas.controlpanel.db.entities.Client;
import com.biosecuritas.controlpanel.db.repositories.ClientRepository;

@Controller
public class ClientController {

	private static final Logger log = LogManager.getLogger(ClientController.class);

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping(path = "/clients")
	public String getAllClients(@RequestParam(required = false) String status, Model model) {
		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("newClient", new Client());
		model.addAttribute("editClient", new Client());
		model.addAttribute("status", status);
		return "/clients/clients";
	}

	@PostMapping("/add-client")
	public String addClient(@ModelAttribute("newClient") @Valid Client client, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("clients", clientRepository.findAll());
			model.addAttribute("newClient", client);
			model.addAttribute("editClient", new Client());
			model.addAttribute("errors", "error");
			log.error(result.toString());
			return "/clients/clients";
		}

		clientRepository.save(client);
		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("status", "created");
		model.addAttribute("newClient", new Client());
		model.addAttribute("editClient", new Client());
		return "redirect:/clients";
	}

	@GetMapping("/edit-client/{id}")
	public String editClient(@PathVariable("id") Integer id, @Valid Client client, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("clients", clientRepository.findAll());
			model.addAttribute("newClient", client);
			model.addAttribute("editClient", new Client());
			model.addAttribute("errors", "error");
			log.error(result.toString());
			return "/clients/clients";
		}

		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("newClient", new Client());
		model.addAttribute("editClient", clientRepository.findById(id));
		model.addAttribute("status", "edit");
		return "/clients/clients";
	}

	@GetMapping("/view-client/{id}")
	public String viewClient(@PathVariable("id") Integer id, @Valid Client client, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("clients", clientRepository.findAll());
			model.addAttribute("newClient", client);
			model.addAttribute("editClient", new Client());
			model.addAttribute("errors", "error");
			log.error(result.toString());
			return "/clients/clients";
		}

		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("newClient", new Client());
		model.addAttribute("editClient", clientRepository.findById(id));
		model.addAttribute("status", "view");
		return "/clients/clients";
	}

	@PostMapping("/update-client")
	public String updateClient(@Valid Client client, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("clients", clientRepository.findAll());
			model.addAttribute("newClient", client);
			model.addAttribute("editClient", new Client());
			model.addAttribute("errors", "error");
			log.error(result.toString());
			return "/clients/clients";
		}

		clientRepository.save(client);
		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("newClient", new Client());
		model.addAttribute("editClient", new Client());
		model.addAttribute("status", "updated");
		return "redirect:/clients";
	}

	@GetMapping("/delete-client/{id}")
	public String deleteClient(@PathVariable("id") Integer id, Model model) {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
		clientRepository.delete(client);
		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("newClient", new Client());
		model.addAttribute("editClient", new Client());
		model.addAttribute("status", "deleted");
		return "redirect:/clients";
	}

	// additional CRUD methods
}
