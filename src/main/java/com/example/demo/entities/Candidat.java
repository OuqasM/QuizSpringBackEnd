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
public class Candidat {
		
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomComplet;
	private String email;
	@ManyToOne
	private Invitation invitation;
	@OneToMany(mappedBy = "candidat")
	private Collection<Resultat> resultats;
}
