package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Administrateur;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Question;
import com.example.demo.entities.Reponse;
import com.example.demo.repositories.AdministrateurRepository;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.QuestionRepository;
import com.example.demo.repositories.ReponseRepository;

@SpringBootApplication
public class QuizBackEndApplication implements CommandLineRunner {

	@Autowired
	AdministrateurRepository adminR;
	@Autowired
	CategoryRepository categorieR;
	@Autowired
	QuestionRepository questionR;
	@Autowired
	ReponseRepository reponseR;
	
	public static void main(String[] args) {
		SpringApplication.run(QuizBackEndApplication.class, args);
	}	
	
	@Override
	public void run(String... args) throws Exception {
		addAdmin();		
		addCategory();
		addQuestion();
		addReponse();
	}
	
	public void addAdmin() {
		
		for(int i = 0 ; i<3 ; i++) {
			Administrateur admin = new Administrateur();
			admin.setNom("nom"+(i+1));
			admin.setUsername("username"+(i+1));
			admin.setRole("admin"+(i+1));
			adminR.save(admin);
		}
	}
	
	int j=0;
	public void addCategory() {
		adminR.findAll().forEach(admin -> {
			for(int i = 0 ; i<3 ; i++) {
			Categorie categorie = new Categorie();
			categorie.setNom("Category"+(++j));
			categorie.setImagelien("image"+j);
			categorie.setAdmin(admin);
			categorieR.save(categorie);
			}
		});
		j=0;
	}
	
	
	public void addQuestion() {
		categorieR.findAll().forEach(categorie -> {
			for(int i = 0 ; i<3 ; i++) {

			String type = Math.random()>0.4? "MultiChoice" :"SingleChoice ";
			Question question = new Question();
			question.setDuree(10+(int)Math.random()*10);
			question.setCategorie(categorie);
			question.setType(type);
			questionR.save(question);
			}
		});
	}
	
	public void addReponse() {
		questionR.findAll().forEach(question -> {
			for(int i = 0 ; i<3 ; i++) {
			boolean correct = Math.random()>0.4? true :false;
			Reponse reponse = new Reponse();
			reponse.setChoix("reponse"+(++j));
			reponse.setCorrecte(correct);
			reponse.setQuestion(question);
			reponseR.save(reponse);
			}
		});
	}

	
	

}
