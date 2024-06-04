package com.Surveys.SurveysManagement.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Surveys.SurveysManagement.domain.entities.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

}
