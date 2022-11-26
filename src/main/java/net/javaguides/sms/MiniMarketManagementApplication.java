package net.javaguides.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.sms.entity.Article;
import net.javaguides.sms.repository.ArticleRepository;

@SpringBootApplication
public class MiniMarketManagementApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MiniMarketManagementApplication.class, args);
	}

	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		 
		 
		
	}

}