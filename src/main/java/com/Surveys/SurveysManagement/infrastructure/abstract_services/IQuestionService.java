package com.Surveys.SurveysManagement.infrastructure.abstract_services;

import org.springframework.stereotype.Service;

import com.Surveys.SurveysManagement.api.dto.request.QuestionRequest;
import com.Surveys.SurveysManagement.api.dto.response.question.QuestionResponse;

@Service
public interface IQuestionService extends CrudService<QuestionRequest, QuestionResponse, Long> {

    QuestionResponse updateDescriptionById(Long id, String text);

}
