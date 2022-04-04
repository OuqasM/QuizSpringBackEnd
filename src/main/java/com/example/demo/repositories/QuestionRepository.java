package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Question;

@RepositoryRestResource
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
