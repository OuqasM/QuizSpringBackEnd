package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Reponse {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String choix;
	private boolean correcte;
	@ManyToOne
	private Question question;
}
