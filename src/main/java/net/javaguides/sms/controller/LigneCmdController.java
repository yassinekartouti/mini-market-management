package net.javaguides.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.LigneCmd;
import net.javaguides.sms.service.ArticleService;
import net.javaguides.sms.service.LigneCmdService;

@Controller
public class LigneCmdController {
	
	private LigneCmdService ligneCmdService;
	@Autowired
	private ArticleService articleService;
	public LigneCmdController(LigneCmdService ligneCmdService) {
		super();
		this.ligneCmdService =ligneCmdService;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/ligneCmds")
	public String listLigneCmds(Model model) {
		model.addAttribute("ligneCmds", ligneCmdService.getAllLigneCmds());
		return "ligneCmds";
	}
	
	@GetMapping("/ligneCmds/new")
	public String createLigneCmdForm(Model model) {
		model.addAttribute("listArticle", articleService.getAllArticles());	
		// create student object to hold student form data
		LigneCmd ligneCmd = new LigneCmd();
		model.addAttribute("ligneCmd", ligneCmd);
		return "create_ligneCmd";
		
	}
	
	@PostMapping("/ligneCmds")
	public String saveLigneCmd(@ModelAttribute("ligneCmd") LigneCmd ligneCmd) {
		ligneCmdService.saveLigneCmd(ligneCmd);
		return "redirect:/ligneCmds";
	}
	
	@GetMapping("/ligneCmds/edit/{id}")
	public String editLigneCmdForm(@PathVariable Integer id, Model model) {
		model.addAttribute("ligneCmd", ligneCmdService.getLigneCmdById(id));
		return "edit_ligneCmd";
	}

	@PostMapping("/ligneCmds/{id}")
	public String updateLigneCmd(@PathVariable Integer id,
			@ModelAttribute("ligneCmd") LigneCmd ligneCmd,
			Model model) {
		
		// get student from database by id
		LigneCmd existingLigneCmd = ligneCmdService.getLigneCmdById(id);
		existingLigneCmd.setNum_ligne(id);
		existingLigneCmd.setQte_cmd(ligneCmd.getQte_cmd());
		existingLigneCmd.setCommande(ligneCmd.getCommande());
		existingLigneCmd.setArticle(ligneCmd.getArticle());
		
		
		// save updated student object
		ligneCmdService.updateLigneCmd(existingLigneCmd);
		return "redirect:/ligneCmds";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/ligneCmds/{id}")
	public String deleteLigneCmd(@PathVariable Integer id) {
		ligneCmdService.deleteLigneCmdById(id);
		return "redirect:/ligneCmds";
	}
	
}
