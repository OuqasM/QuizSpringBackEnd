package com.example.demo.entities;

import java.util.Collection;

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
public class LigneQuestion {
		
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int duree;
	@ManyToOne
	private Question question;
	@ManyToOne
	private Questionnaire questionnaire;
	
}