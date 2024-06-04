package com.Surveys.SurveysManagement.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Surveys.SurveysManagement.api.dto.request.SurveyRequest;
import com.Surveys.SurveysManagement.api.dto.response.survey.SurveyBasicResponse;
import com.Surveys.SurveysManagement.api.dto.response.survey.SurveyResponse;
import com.Surveys.SurveysManagement.infrastructure.abstract_services.ISurveyService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/survey")
@AllArgsConstructor
public class SurveyController {

    @Autowired
    private final ISurveyService iSurveyService;

    @GetMapping
    public ResponseEntity<Page<SurveyBasicResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(this.iSurveyService.getAll(page - 1, size));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SurveyResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.iSurveyService.getById(id));
    }

    @PostMapping
    public ResponseEntity<SurveyBasicResponse> create(
            @Validated @RequestBody SurveyRequest request) {
        return ResponseEntity.ok(this.iSurveyService.create(request));
    }
}
