package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Livraison;
import net.javaguides.sms.service.LivraisonService;

@Controller
public class LivraisonController {
	
	private LivraisonService livraisonService;

	public LivraisonController(LivraisonService livraisonService) {
		super();
		this.livraisonService =livraisonService;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/livraisons")
	public String listLivraisons(Model model) {
		model.addAttribute("livraisons", livraisonService.getAllLivraisons());
		return "livraisons";
	}
	
	@GetMapping("/livraisons/new")
	public String createLivraisonForm(Model model) {
		
		// create student object to hold student form data
		Livraison livraison = new Livraison();
		model.addAttribute("livraison", livraison);
		return "create_livraison";
		
	}
	
	@PostMapping("/livraisons")
	public String saveLivraison(@ModelAttribute("livraison") Livraison livraison) {
		livraisonService.saveLivraison(livraison);
		return "redirect:/livraisons";
	}
	
	@GetMapping("/livraisons/edit/{id}")
	public String editLivraisonForm(@PathVariable Integer id, Model model) {
		model.addAttribute("livraison", livraisonService.getLivraisonById(id));
		return "edit_livraison";
	}

	@PostMapping("/livraisons/{id}")
	public String updateLivraison(@PathVariable Integer id,
			@ModelAttribute("livraison") Livraison livraison,
			Model model) {
		
		// get student from database by id
		Livraison existingLivraison = livraisonService.getLivraisonById(id);
		existingLivraison.setNum_liv(id);
		existingLivraison.setDate_liv(livraison.getDate_liv());
		existingLivraison.setFournisseur(livraison.getFournisseur());
		
		
		
		// save updated student object
		livraisonService.updateLivraison(existingLivraison);
		return "redirect:/livraisons";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/livraisons/{id}")
	public String deleteLivraison(@PathVariable Integer id) {
		livraisonService.deleteLivraisonById(id);
		return "redirect:/livraisons";
	}
	
}
