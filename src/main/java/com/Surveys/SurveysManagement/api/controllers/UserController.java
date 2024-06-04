package com.Surveys.SurveysManagement.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Surveys.SurveysManagement.api.dto.request.UserRequest;
import com.Surveys.SurveysManagement.api.dto.response.user.UserResponse;
import com.Surveys.SurveysManagement.infrastructure.abstract_services.IUserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
public class UserController {

    @Autowired
    private final IUserService iUserService;

    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(this.iUserService.getAll(page - 1, size));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.iUserService.getById(id));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<UserResponse> create(
            @Validated @RequestBody UserRequest request) {
        return ResponseEntity.ok(this.iUserService.create(request));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<UserResponse> update(
            @Validated @RequestBody UserRequest request,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.iUserService.update(request, id));
    }

}
