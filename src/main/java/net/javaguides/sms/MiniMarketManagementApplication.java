package net.javaguides.sms;


import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import net.javaguides.sms.entity.Article;
import net.javaguides.sms.repository.ArticleRepository;

@SpringBootApplication
public class MiniMarketManagementApplication implements CommandLineRunner{
	
	public static Logger logger = LoggerFactory.getLogger(MiniMarketManagementApplication.class);
	
	@PostConstruct
	public void intt()
	{
		logger.info("Application starter...");
	}
	public static void main(String[] args) {
		logger.info("Application executed...");
		SpringApplication.run(MiniMarketManagementApplication.class, args);
	}
	

	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		 
		 
		
	}

}