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
public class Categorie {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String imagelien;
	private String nom;
	@OneToMany(mappedBy = "categorie")
	private Collection<Question> questions;
	@OneToMany(mappedBy = "questionnaire")
	private Collection<LigneCategorie> ligneCategories;
	@ManyToOne
	private Administrateur admin;
	
	
}
