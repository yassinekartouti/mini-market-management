package net.javaguides.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Article;
import net.javaguides.sms.repository.ArticleRepository;
import net.javaguides.sms.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{

	private ArticleRepository articleRepository;
	
	public ArticleServiceImpl(	ArticleRepository articleRepository) {
		super();
		this.articleRepository = articleRepository;
	}

	@Override
	public List<Article> getAllArticles() {
		return articleRepository.findAll();
	}

	@Override
	public Article saveArticle(Article article) {
		return articleRepository.save(article);
	}

	@Override
	public Article getArticleById(Integer cod_art) {
		return articleRepository.findById(cod_art).get();
	}

	@Override
	public Article updateArticle(Article article) {
		return articleRepository.save(article);
	}

	@Override
	public void deleteArticleById(Integer cod_art) {
		articleRepository.deleteById(cod_art);	
	}

}
