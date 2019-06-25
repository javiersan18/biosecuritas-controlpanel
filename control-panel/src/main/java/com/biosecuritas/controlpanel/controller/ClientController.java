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

import com.biosecuritas.controlpanel.db.entities.Client;
import com.biosecuritas.controlpanel.db.repositories.ClientRepository;

@Controller
public class ClientController {

	private static final Logger log = LogManager.getLogger(ClientController.class);

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping(path = "/clients")
	public String getAllClients(@RequestParam(required = false) String status,
			@RequestParam(required = false) String errorDesc, Model model) {
		List<Client> clients = finAllWithNumHydrolyzers();
		model.addAttribute("clients", clients);
		model.addAttribute("newClient", new Client());
		model.addAttribute("editClient", new Client());
		if (status == null && clients.isEmpty()) {
			status = "empty";
		}
		model.addAttribute("status", status);
		model.addAttribute("errorDesc", errorDesc);
		return "clients/clients";
	}

	private List<Client> finAllWithNumHydrolyzers() {
		// List<Object[]> count = clientRepository.countHydrosAllClients();
		List<Client> clients = clientRepository.findAll();

		/*
		 * for (Object[] o : count) { Integer nH = ((BigInteger) o[1]).intValue();
		 * Integer id = (Integer) o[0]; for (Client c : clients) { if
		 * (c.getId().equals(id)) { c.setNumHydros(nH); } } }
		 */
		return clients;
	}

	@PostMapping("/add-client")
	public String addClient(@ModelAttribute("newClient") @Valid Client client, BindingResult result, Model model) {

		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("status", "created");
		model.addAttribute("newClient", new Client());
		model.addAttribute("editClient", new Client());

		if (result.hasErrors()) {
			model.addAttribute("newClient", client);
			model.addAttribute("status", "error");
			model.addAttribute("errorDesc", "errordesc");
			log.error(result.toString());
			return "clients/clients";
		}

		clientRepository.save(client);
		return "redirect:/clients";
	}

	@GetMapping("/edit-client/{id}")
	public String editClient(@PathVariable("id") Integer id, @Valid Client client, BindingResult result, Model model) {

		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("newClient", new Client());
		model.addAttribute("editClient", clientRepository.findById(id));
		model.addAttribute("status", "edit");

		if (result.hasErrors()) {
			model.addAttribute("newClient", client);
			model.addAttribute("editClient", new Client());
			model.addAttribute("status", "error");
			model.addAttribute("errorDesc", "errordesc");
			log.error(result.toString());
			return "clients/clients";
		}

		return "clients/clients";
	}

	@GetMapping("/view-client/{id}")
	public String viewClient(@PathVariable("id") Integer id, @Valid Client client, BindingResult result, Model model) {

		model.addAttribute("clients", finAllWithNumHydrolyzers());
		model.addAttribute("newClient", new Client());
		model.addAttribute("editClient", clientRepository.findById(id));
		model.addAttribute("status", "view");

		if (result.hasErrors()) {
			model.addAttribute("newClient", client);
			model.addAttribute("editClient", new Client());
			model.addAttribute("status", "error");
			model.addAttribute("errorDesc", "errordesc");
			log.error(result.toString());
			return "clients/clients";
		}

		return "clients/clients";
	}

	@PostMapping("/update-client")
	public String updateClient(@Valid Client client, BindingResult result, Model model) {

		model.addAttribute("clients", clientRepository.findAll());
		model.addAttribute("newClient", new Client());
		model.addAttribute("editClient", new Client());
		model.addAttribute("status", "updated");

		if (result.hasErrors()) {
			model.addAttribute("newClient", client);
			model.addAttribute("status", "error");
			model.addAttribute("errorDesc", "errordesc");
			log.error(result.toString());
			return "clients/clients";
		}

		clientRepository.save(client);
		return "redirect:/clients";
	}

	@GetMapping("/delete-client/{id}")
	public String deleteClient(@PathVariable("id") Integer id, Model model) {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));

		try {
			clientRepository.delete(client);
			model.addAttribute("clients", clientRepository.findAll());
			model.addAttribute("newClient", new Client());
			model.addAttribute("editClient", new Client());
			model.addAttribute("status", "deleted");
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("status", "error");
			model.addAttribute("errorDesc",
					"No se ha podido borrar el cliente porque existen Granjas o Contenedores asociados a este cliente.");
		}

		return "redirect:/clients";
	}

	// additional CRUD methods
}
