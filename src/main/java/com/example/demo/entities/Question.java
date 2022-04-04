package com.example.demo.entities;

import java.util.Collection;

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
public class Question {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int duree;
	@ManyToOne
	private Categorie categorie;
	private String type;
	@OneToMany(mappedBy = "question")
	private Collection<Reponse> reponses;
	@OneToMany(mappedBy = "question")
	private Collection<Reponse> ligneQuestions;
}
