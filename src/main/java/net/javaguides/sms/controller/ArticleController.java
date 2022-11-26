package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Article;
import net.javaguides.sms.service.ArticleService;

@Controller
public class ArticleController {
	
	private ArticleService articleService;

	public ArticleController(ArticleService articleService) {
		super();
		this.articleService = articleService;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/articles")
	public String listArticles(Model model) {
		model.addAttribute("articles", articleService.getAllArticles());
		return "articles";
	}
	
	@GetMapping("/articles/new")
	public String createArticleForm(Model model) {
		
		// create student object to hold student form data
		Article article = new Article();
		model.addAttribute("article", article);
		return "create_article";
		
	}
	
	@PostMapping("/articles")
	public String saveArticle(@ModelAttribute("article") Article article) {
		articleService.saveArticle(article);
		return "redirect:/articles";
	}
	
	@GetMapping("/articles/edit/{id}")
	public String editArticleForm(@PathVariable Integer id, Model model) {
		model.addAttribute("article", articleService.getArticleById(id));
		return "edit_article";
	}

	@PostMapping("/articles/{id}")
	public String updateArticle(@PathVariable Integer id,
			@ModelAttribute("article") Article article,
			Model model) {
		
		// get student from database by id
		Article existingArticle = articleService.getArticleById(id);
		existingArticle.setCod_art(id);
		existingArticle.setNom_art(article.getNom_art());
		existingArticle.setPu(article.getPu());
		existingArticle.setQte_stock(article.getQte_stock());
		
		// save updated student object
		articleService.updateArticle(existingArticle);
		return "redirect:/articles";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/articles/{id}")
	public String deleteArticle(@PathVariable Integer id) {
		articleService.deleteArticleById(id);
		return "redirect:/articles";
	}
	
}
