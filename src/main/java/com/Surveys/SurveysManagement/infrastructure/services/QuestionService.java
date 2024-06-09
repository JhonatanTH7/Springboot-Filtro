package com.Surveys.SurveysManagement.infrastructure.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Surveys.SurveysManagement.api.dto.request.OptionQuestionRequest;
import com.Surveys.SurveysManagement.api.dto.request.QuestionRequest;
import com.Surveys.SurveysManagement.api.dto.response.question.OptionQuestionResponse;
import com.Surveys.SurveysManagement.api.dto.response.question.QuestionResponse;
import com.Surveys.SurveysManagement.domain.entities.OptionQuestion;
import com.Surveys.SurveysManagement.domain.entities.Question;
import com.Surveys.SurveysManagement.domain.repositories.OptionQuestionRepository;
import com.Surveys.SurveysManagement.domain.repositories.QuestionRepository;
import com.Surveys.SurveysManagement.domain.repositories.SurveyRepository;
import com.Surveys.SurveysManagement.infrastructure.abstract_services.IQuestionService;
import com.Surveys.SurveysManagement.infrastructure.helpers.EntityToEntity;
import com.Surveys.SurveysManagement.util.exceptions.ResourceNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestionService implements IQuestionService {

    @Autowired
    private final QuestionRepository questionRepository;

    @Autowired
    private final SurveyRepository surveyRepository;

    @Autowired
    private final OptionQuestionRepository optionQuestionRepository;

    @Override
    public Page<QuestionResponse> getAll(int page, int size) {
        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        return this.questionRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public QuestionResponse create(QuestionRequest request) {
        Question entity = this.questionRepository.save(this.requestToEntity(request));
        if (entity.getType().equalsIgnoreCase("closed")) {
            entity.setOptions(optionToEntity(request.getOptions(), entity));
        }
        return this.entityToResponse(entity);
    }

    @Override
    public QuestionResponse update(QuestionRequest request, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        this.questionRepository.delete(this.find(id));
    }

    @Override
    public QuestionResponse updateDescriptionById(Long id, String text) {
        return null;
    }

    private Question find(Long id) {
        return this.questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question with the id: '" + id + "' not found"));
    }

    private QuestionResponse entityToResponse(Question entity) {
        QuestionResponse questionResponse = EntityToEntity.entityToEntity(entity, QuestionResponse.class);
        if (entity.getOptions() != null) {
            questionResponse.setOptions(entity.getOptions().stream().map(option -> {
                return EntityToEntity.entityToEntity(option, OptionQuestionResponse.class);
            }).toList());
        }
        return questionResponse;
    }

    private Question requestToEntity(QuestionRequest request) {
        Question entity = EntityToEntity.entityToEntity(request, Question.class);
        entity.setSurvey(this.surveyRepository.findById(request.getIdSurvey())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Survey with the id: '" + request.getIdSurvey() + "' not found")));

        if (entity.getType().equalsIgnoreCase("closed")) {
            entity.setOptions(new ArrayList<>());
        }
        return entity;
    }

    private List<OptionQuestion> optionToEntity(List<OptionQuestionRequest> optionsRequest, Question entityQuestion) {
        if (optionsRequest != null) {
            return optionsRequest.stream().map(option -> {
                OptionQuestion optionEntity = EntityToEntity.entityToEntity(option, OptionQuestion.class);
                optionEntity.setQuestion(entityQuestion);
                return this.optionQuestionRepository.save(optionEntity);
            }).toList();
        }
        return new ArrayList<>();
    }

}
