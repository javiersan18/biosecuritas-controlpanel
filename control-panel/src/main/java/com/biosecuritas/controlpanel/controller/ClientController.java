package com.biosecuritas.controlpanel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biosecuritas.controlpanel.db.entities.Client;
import com.biosecuritas.controlpanel.db.entities.User;
import com.biosecuritas.controlpanel.db.repositories.ClientRepository;
import com.biosecuritas.controlpanel.db.repositories.UserRepository;

@Controller
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping(path = "/clients")	
	@ResponseBody
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}

	@PostMapping("/add-client")
	public String addClient(@Valid Client client, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-client";
		}

		clientRepository.save(client);
		model.addAttribute("client", clientRepository.findAll());
		return "index";
	}

	@PostMapping("/update-client/{id}")
	public String updateClient(@PathVariable("id") Integer id, @Valid Client client, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			// client.setId(id);
			return "update-user";
		}

		clientRepository.save(client);
		model.addAttribute("client", clientRepository.findAll());
		return "index";
	}

	@GetMapping("/delete-client/{id}")
	public String deleteClient(@PathVariable("id") Integer id, Model model) {
		Client user = clientRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		clientRepository.delete(user);
		model.addAttribute("client", clientRepository.findAll());
		return "index";
	}

	// additional CRUD methods
}
