package com.Surveys.SurveysManagement.infrastructure.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Surveys.SurveysManagement.api.dto.request.SurveyRequest;
import com.Surveys.SurveysManagement.api.dto.response.survey.SurveyBasicResponse;
import com.Surveys.SurveysManagement.api.dto.response.survey.SurveyResponse;
import com.Surveys.SurveysManagement.domain.entities.Survey;
import com.Surveys.SurveysManagement.domain.repositories.SurveyRepository;
import com.Surveys.SurveysManagement.domain.repositories.UserRepository;
import com.Surveys.SurveysManagement.infrastructure.abstract_services.ISurveyService;
import com.Surveys.SurveysManagement.infrastructure.helpers.EntityToEntity;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class SurveyService implements ISurveyService {

    @Autowired
    private final SurveyRepository surveyRepository;

    @Autowired
    private final UserRepository userRepository;

    @Override
    public Page<SurveyBasicResponse> getAll(int page, int size) {
        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        return this.surveyRepository.findAll(pagination).map(this::entityToBasicResponse);
    }

    @Override
    public SurveyResponse getById(Long id) {
        return entityToResponse(find(id));
    }

    @Override
    public SurveyBasicResponse create(SurveyRequest request) {
        Survey survey = EntityToEntity.entityToEntity(request, Survey.class);
        survey.setQuestions(new ArrayList<>());
        survey.setCreator(this.userRepository.findById(request.getIdCreator()).orElseThrow());
        return this.entityToBasicResponse(
                this.surveyRepository.save(survey));
    }

    private Survey find(Long id) {
        return this.surveyRepository.findById(id).orElseThrow();
    }

    private SurveyBasicResponse entityToBasicResponse(Survey entity) {
        return EntityToEntity.entityToEntity(entity, SurveyBasicResponse.class);
    }

    private SurveyResponse entityToResponse(Survey entity) {
        SurveyResponse surveyResponse = EntityToEntity.entityToEntity(entity, SurveyResponse.class);
        surveyResponse.setQuestions(null);
        return surveyResponse;
    }

}
