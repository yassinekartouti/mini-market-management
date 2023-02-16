package net.javaguides.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Client;
import net.javaguides.sms.service.ClientService;

@Controller
public class ClientController {
	@Autowired
	private ClientService clientService;

	public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/clients")
	public String listClients(Model model) {
		model.addAttribute("clients", clientService.getAllClients());
		return "clients";
	}
	
	@GetMapping("/clients/new")
	public String createClientForm(Model model) {
		
		// create student object to hold student form data
		Client client = new Client();
		model.addAttribute("client", client);
		return "create_client";
		
	}
	
	@PostMapping("/clients")
	public String saveClient(@ModelAttribute("client") Client client) {
		clientService.saveClient(client);
		return "redirect:/clients";
	}
	
	@GetMapping("/clients/edit/{id}")
	public String editClientForm(@PathVariable Integer id, Model model) {
		model.addAttribute("client", clientService.getClientById(id));
		return "edit_client";
	}

	@PostMapping("/clients/{id}")
	public String updateClient(@PathVariable Integer id,
			@ModelAttribute("client") Client client,
			Model model) {
		
		// get student from database by id
		Client existingClient = clientService.getClientById(id);
		existingClient.setCod_cli(id);
		existingClient.setNom_cli(client.getNom_cli());
		existingClient.setPre_cli(client.getPre_cli());
		existingClient.setAdr_cli(client.getAdr_cli());
		existingClient.setTel_cli(client.getTel_cli());
		existingClient.setVille_cli(client.getVille_cli());
		
		// save updated student object
		clientService.updateClient(existingClient);
		return "redirect:/clients";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/clients/{id}")
	public String deleteClient(@PathVariable Integer id) {
		clientService.deleteClientById(id);
		return "redirect:/clients";
	}
	
}
