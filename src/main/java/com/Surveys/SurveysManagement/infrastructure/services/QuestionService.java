package com.Surveys.SurveysManagement.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Surveys.SurveysManagement.api.dto.request.QuestionRequest;
import com.Surveys.SurveysManagement.api.dto.response.question.OptionQuestionResponse;
import com.Surveys.SurveysManagement.api.dto.response.question.QuestionResponse;
import com.Surveys.SurveysManagement.domain.entities.Question;
import com.Surveys.SurveysManagement.domain.repositories.QuestionRepository;
import com.Surveys.SurveysManagement.infrastructure.abstract_services.IQuestionService;
import com.Surveys.SurveysManagement.infrastructure.helpers.EntityToEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestionService implements IQuestionService {

    @Autowired
    private final QuestionRepository questionRepository;

    @Override
    public Page<QuestionResponse> getAll(int page, int size) {
        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        return this.questionRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public QuestionResponse create(QuestionRequest request) {
        return null;
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
        return this.questionRepository.findById(id).orElseThrow();
    }

    private QuestionResponse entityToResponse(Question entity) {
        QuestionResponse questionResponse = EntityToEntity.entityToEntity(entity, QuestionResponse.class);
        questionResponse.setOptions(entity.getOptions().stream().map(option -> {
            return EntityToEntity.entityToEntity(option, OptionQuestionResponse.class);
        }).toList());
        return questionResponse;
    }

}
