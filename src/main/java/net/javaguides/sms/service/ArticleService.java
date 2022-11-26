package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.entity.Article;

public interface ArticleService {
	List<Article> getAllArticles();
	
	Article saveArticle(Article article);
	
	Article getArticleById(Integer cod_art);
	
	Article updateArticle(Article article);
	
	void deleteArticleById(Integer cod_art);
}