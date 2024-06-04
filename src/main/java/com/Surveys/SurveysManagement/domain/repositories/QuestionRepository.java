package com.Surveys.SurveysManagement.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Surveys.SurveysManagement.domain.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
