package com.Surveys.SurveysManagement.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Surveys.SurveysManagement.api.dto.request.QuestionRequest;
import com.Surveys.SurveysManagement.api.dto.response.question.QuestionResponse;
import com.Surveys.SurveysManagement.infrastructure.abstract_services.IQuestionService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/questions")
@AllArgsConstructor
public class QuestionController {

    @Autowired
    private final IQuestionService iQuestionService;

    @Operation(summary = "Shows all questions", description = "Displays all questions that have been saved in the database")
    @GetMapping
    public ResponseEntity<Page<QuestionResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(this.iQuestionService.getAll(page - 1, size));
    }

    @Operation(summary = "Create a question ans it's options", description = "create a question with the sent parameters")
    @PostMapping
    public ResponseEntity<QuestionResponse> create(
            @Validated @RequestBody QuestionRequest request) {
        return ResponseEntity.ok(this.iQuestionService.create(request));
    }

    @Operation(summary = "Delete a question", description = "Delete the question to which the id refers to")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.iQuestionService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
