package com.Surveys.SurveysManagement.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

import com.Surveys.SurveysManagement.api.dto.request.UserRequest;
import com.Surveys.SurveysManagement.api.dto.response.user.UserResponse;

public interface IUserService {

    Page<UserResponse> getAll(int page, int size);

    UserResponse getById(Long id);

    UserResponse create(UserRequest request);

    UserResponse update(UserRequest request, Long id);

}
