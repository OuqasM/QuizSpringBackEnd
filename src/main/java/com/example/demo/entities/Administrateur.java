package com.example.demo.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Administrateur {
		
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String password;
	private String nom;
	private String role;
	
	@OneToMany(mappedBy = "admin")
	private Collection<Categorie> categories;
	@OneToMany(mappedBy = "admin")
	private Collection<Questionnaire> questionnaires;	
	@OneToMany(mappedBy = "admin")
	private Collection<Invitation> invitations;
	
}
