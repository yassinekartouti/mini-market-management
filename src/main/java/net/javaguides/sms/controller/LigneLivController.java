package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.LigneLiv;
import net.javaguides.sms.service.LigneLivService;

@Controller
public class LigneLivController {
	
	private LigneLivService ligneLivService;

	public LigneLivController(LigneLivService ligneLivService) {
		super();
		this.ligneLivService =ligneLivService;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/ligneLivs")
	public String listLigneLivs(Model model) {
		model.addAttribute("ligneLivs", ligneLivService.getAllLigneLivs());
		return "ligneLivs";
	}
	
	@GetMapping("/ligneLivs/new")
	public String createLigneLivForm(Model model) {
		
		// create student object to hold student form data
		LigneLiv ligneLiv = new LigneLiv();
		model.addAttribute("ligneLiv", ligneLiv);
		return "create_ligneLiv";
		
	}
	
	@PostMapping("/ligneLivs")
	public String saveLigneLiv(@ModelAttribute("ligneLiv") LigneLiv ligneLiv) {
		ligneLivService.saveLigneLiv(ligneLiv);
		return "redirect:/ligneLivs";
	}
	
	@GetMapping("/ligneLivs/edit/{id}")
	public String editLigneCmdForm(@PathVariable Integer id, Model model) {
		model.addAttribute("ligneLiv", ligneLivService.getLigneLivById(id));
		return "edit_ligneLiv";
	}

	@PostMapping("/ligneLivs/{id}")
	public String updateLigneLiv(@PathVariable Integer id,
			@ModelAttribute("ligneLiv") LigneLiv ligneLiv,
			Model model) {
		
		// get student from database by id
		LigneLiv existingLigneLiv = ligneLivService.getLigneLivById(id);
		existingLigneLiv.setNum_ligneliv(id);
		existingLigneLiv.setQte_liv(ligneLiv.getQte_liv());
		existingLigneLiv.setLivraison(ligneLiv.getLivraison());
		existingLigneLiv.setArticle(ligneLiv.getArticle());
		
		
		// save updated student object
		ligneLivService.updateLigneLiv(existingLigneLiv);
		return "redirect:/ligneLivs";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/ligneLivs/{id}")
	public String deleteLigneLiv(@PathVariable Integer id) {
		ligneLivService.deleteLigneLivById(id);
		return "redirect:/ligneLivs";
	}
	
}
