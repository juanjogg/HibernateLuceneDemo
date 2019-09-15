package com.example.demo;

import com.example.demo.model.Player;
import com.example.demo.repo.PlayerRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.Search;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.provider.HibernateUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private PlayerRepo playerRepo;
	@PersistenceContext
	private EntityManager entityManager;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {



		Player juan = new Player();
		juan.setName("Juan");
		juan.setLastName("Guarin");
		juan.setEmail("juan@gmail.com");
		juan.setUsername("juanjogg");

		playerRepo.save(juan);

		Player james = new Player();
		james.setName("James");
		james.setLastName("Rodriguez");
		james.setEmail("james@gmail.com");
		james.setUsername("jrodri");

		playerRepo.save(james);

		Player keylor = new Player();

		keylor.setName("Keylor");
		keylor.setLastName("Navas");
		keylor.setEmail("knavas@gmail.com");
		keylor.setUsername("knavas");

		playerRepo.save(keylor);


	}
}
