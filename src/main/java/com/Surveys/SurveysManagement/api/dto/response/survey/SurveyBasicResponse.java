package com.Surveys.SurveysManagement.api.dto.response.survey;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyBasicResponse {

    @Schema(description = "Id of the survey")
    private Long idSurvey;
    @Schema(description = "Title of the survey")
    private String title;
    @Schema(description = "Description of the survey")
    private String description;
    @Schema(description = "Creation date of the survey")
    private LocalDateTime creationDate;
    @Schema(description = "Status of the survey")
    private boolean active;

}
