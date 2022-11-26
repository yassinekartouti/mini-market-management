package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Fournisseur;
import net.javaguides.sms.service.FournisseurService;

@Controller
public class FournisseurController {
	
	private FournisseurService fournisseurService;

	public FournisseurController(FournisseurService fournisseurService) {
		super();
		this.fournisseurService = fournisseurService;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/fournisseurs")
	public String listFournisseurs(Model model) {
		model.addAttribute("fournisseurs", fournisseurService.getAllFournisseurs());
		return "fournisseurs";
	}
	
	@GetMapping("/fournisseurs/new")
	public String createFournisseurForm(Model model) {
		
		// create student object to hold student form data
		Fournisseur fournisseur = new Fournisseur();
		model.addAttribute("fournisseur", fournisseur);
		return "create_fournisseur";
		
	}
	
	@PostMapping("/fournisseurs")
	public String saveFournisseur(@ModelAttribute("fournisseur") Fournisseur fournisseur) {
		fournisseurService.saveFournisseur(fournisseur);
		return "redirect:/fournisseurs";
	}
	
	@GetMapping("/fournisseurs/edit/{id}")
	public String editFournisseurForm(@PathVariable Integer id, Model model) {
		model.addAttribute("fournisseur", fournisseurService.getFournisseurById(id));
		return "edit_fournisseur";
	}

	@PostMapping("/fournisseurs/{id}")
	public String updateFournisseur(@PathVariable Integer id,
			@ModelAttribute("fournisseur") Fournisseur fournisseur,
			Model model) {
		
		// get student from database by id
		Fournisseur existingFournisseur = fournisseurService.getFournisseurById(id);
		existingFournisseur.setCod_four(id);
		existingFournisseur.setNom_four(fournisseur.getNom_four());
		existingFournisseur.setVille_four(fournisseur.getVille_four());
		existingFournisseur.setTel_four(fournisseur.getTel_four());
		
		
		// save updated student object
		fournisseurService.updateFournisseur(existingFournisseur);
		return "redirect:/fournisseurs";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/fournisseurs/{id}")
	public String deleteFournisseur(@PathVariable Integer id) {
		fournisseurService.deleteFournisseurById(id);
		return "redirect:/fournisseurs";
	}
	
}
