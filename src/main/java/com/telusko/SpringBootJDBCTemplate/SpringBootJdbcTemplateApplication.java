package com.telusko.SpringBootJDBCTemplate;

import com.telusko.SpringBootJDBCTemplate.models.Aliens;
import com.telusko.SpringBootJDBCTemplate.repo.AliensRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootJdbcTemplateApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBootJdbcTemplateApplication.class, args);
		Aliens alien1 = context.getBean(Aliens.class);
		alien1.setId(1);
		alien1.setName("aditya");
		alien1.setTech("java");

		AliensRepo repo = context.getBean(AliensRepo.class);
		repo.save(alien1);
		System.out.println(repo.findAll().toString());
	}

}
