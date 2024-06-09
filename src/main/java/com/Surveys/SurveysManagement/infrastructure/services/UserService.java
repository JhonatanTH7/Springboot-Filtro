package com.Surveys.SurveysManagement.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Surveys.SurveysManagement.api.dto.request.UserRequest;
import com.Surveys.SurveysManagement.api.dto.response.user.UserResponse;
import com.Surveys.SurveysManagement.domain.entities.User;
import com.Surveys.SurveysManagement.domain.repositories.UserRepository;
import com.Surveys.SurveysManagement.infrastructure.abstract_services.IUserService;
import com.Surveys.SurveysManagement.infrastructure.helpers.EntityToEntity;
import com.Surveys.SurveysManagement.util.exceptions.ResourceNotFoundException;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public Page<UserResponse> getAll(int page, int size) {
        if (page < 0)
            page = 0;
        PageRequest pagination = PageRequest.of(page, size);
        return this.userRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public UserResponse getById(Long id) {
        return entityToResponse(find(id));
    }

    @Override
    public UserResponse create(UserRequest request) {
        return this.entityToResponse(this.userRepository.save(EntityToEntity.entityToEntity(request, User.class)));
    }

    @Override
    public UserResponse update(UserRequest request, Long id) {
        this.find(id);
        User userInfoUpdated = EntityToEntity.entityToEntity(request, User.class);
        userInfoUpdated.setIdUser(id);
        return this.entityToResponse(this.userRepository.save(userInfoUpdated));
    }

    private User find(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with the id: '" + id + "' not found"));
    }

    private UserResponse entityToResponse(User entity) {
        return EntityToEntity.entityToEntity(entity, UserResponse.class);
    }

}
