package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Commande;
import net.javaguides.sms.service.CommandeService;

@Controller
public class CommandeController {
	
	private CommandeService commandeService;

	public CommandeController(CommandeService commandeService) {
		super();
		this.commandeService = commandeService;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/commandes")
	public String listCommandes(Model model) {
		model.addAttribute("commandes", commandeService.getAllCommandes());
		return "commandes";
	}
	
	@GetMapping("/commandes/new")
	public String createCommandeForm(Model model) {
		
		// create student object to hold student form data
		Commande commande = new Commande();
		model.addAttribute("commande", commande);
		return "create_commande";
		
	}
	
	@PostMapping("/commandes")
	public String saveCommande(@ModelAttribute("commande") Commande commande) {
		commandeService.saveCommande(commande);
		return "redirect:/commandes";
	}
	
	@GetMapping("/commandes/edit/{id}")
	public String editCommandeForm(@PathVariable Integer id, Model model) {
		model.addAttribute("commande", commandeService.getCommandeById(id));
		return "edit_commande";
	}

	@PostMapping("/commandes/{id}")
	public String updateCommande(@PathVariable Integer id,
			@ModelAttribute("commande") Commande commande,
			Model model) {
		
		// get student from database by id
		Commande existingCommande = commandeService.getCommandeById(id);
		existingCommande.setNum_cmd(id);
		existingCommande.setDate_cmd(commande.getDate_cmd());
		existingCommande.setClient(commande.getClient());
		
		
		// save updated student object
		commandeService.updateCommande(existingCommande);
		return "redirect:/commandes";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/commandes/{id}")
	public String deleteCommande(@PathVariable Integer id) {
		commandeService.deleteCommandeById(id);
		return "redirect:/commandes";
	}
	
}
