package com.Surveys.SurveysManagement.infrastructure.abstract_services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.Surveys.SurveysManagement.api.dto.request.SurveyRequest;
import com.Surveys.SurveysManagement.api.dto.response.survey.SurveyBasicResponse;
import com.Surveys.SurveysManagement.api.dto.response.survey.SurveyResponse;

@Service
public interface ISurveyService {

    Page<SurveyBasicResponse> getAll(int page, int size);

    SurveyResponse getById(Long id);

    SurveyBasicResponse create(SurveyRequest request);

}
