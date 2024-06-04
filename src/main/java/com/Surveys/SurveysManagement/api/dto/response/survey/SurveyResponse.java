package com.Surveys.SurveysManagement.api.dto.response.survey;

import java.util.List;

import com.Surveys.SurveysManagement.api.dto.response.question.QuestionResponse;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class SurveyResponse extends SurveyBasicResponse {

    @Schema(description = "Questions of the survey")
    List<QuestionResponse> questions;

}
