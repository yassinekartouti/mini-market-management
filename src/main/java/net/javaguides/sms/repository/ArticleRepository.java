package net.javaguides.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.sms.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>{

}
