package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Societe;
import net.javaguides.sms.service.SocieteService;

@Controller
public class SocieteController {
	
	private SocieteService societeService;

	public SocieteController(SocieteService societeService) {
		super();
		this.societeService =societeService;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/societes")
	public String listSocietes(Model model) {
		model.addAttribute("societes", societeService.getAllSocietes());
		return "societes";
	}
	
	@GetMapping("/societes/new")
	public String createSocieteForm(Model model) {
		
		// create student object to hold student form data
		Societe societe = new Societe();
		model.addAttribute("societe", societe);
		return "create_societe";
		
	}
	
	@PostMapping("/societes")
	public String saveSociete(@ModelAttribute("societe") Societe societe) {
		societeService.saveSociete(societe);
		return "redirect:/societes";
	}
	
	@GetMapping("/societes/edit/{id}")
	public String editLigneCmdForm(@PathVariable Integer id, Model model) {
		model.addAttribute("societe", societeService.getSocieteById(id));
		return "edit_societe";
	}

	@PostMapping("/societes/{id}")
	public String updateSociete(@PathVariable Integer id,
			@ModelAttribute("societe") Societe societe,
			Model model) {
		
		// get student from database by id
		Societe existingSociete = societeService.getSocieteById(id);
		existingSociete.setCod_ste(id);
		existingSociete.setNom_ste(societe.getNom_ste());
		existingSociete.setTel_ste(societe.getTel_ste());
		existingSociete.setFax_ste(societe.getFax_ste());
		existingSociete.setVille_ste(societe.getVille_ste());
		existingSociete.setFournisseur(societe.getFournisseur());
		
		
		// save updated student object
		societeService.updateSociete(existingSociete);
		return "redirect:/societes";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/societes/{id}")
	public String deleteLigneCmd(@PathVariable Integer id) {
		societeService.deleteSocieteById(id);
		return "redirect:/societes";
	}
	
}
