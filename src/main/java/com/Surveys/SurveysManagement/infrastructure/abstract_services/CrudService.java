package com.Surveys.SurveysManagement.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

public interface CrudService<REQUEST, RESPONSE, TYPE> {

    Page<RESPONSE> getAll(int page, int size);

    RESPONSE create(REQUEST request);

    RESPONSE update(REQUEST request, TYPE id);

    void delete(TYPE id);

}
