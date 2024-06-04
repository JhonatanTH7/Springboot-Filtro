package com.Surveys.SurveysManagement.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Surveys.SurveysManagement.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
