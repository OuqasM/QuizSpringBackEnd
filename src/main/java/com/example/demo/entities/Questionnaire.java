package com.example.demo.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Questionnaire {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dataCreation;
	@OneToMany(mappedBy = "questionnaire")
	private Collection<LigneQuestion> ligneQuestions;
	@OneToMany(mappedBy = "questionnaire")
	private Collection<LigneCategorie> ligneCategories;
	@ManyToOne
	private Administrateur admin;
	@OneToMany(mappedBy = "questionnaire")
	private Collection<Resultat> resultats;
	
}
