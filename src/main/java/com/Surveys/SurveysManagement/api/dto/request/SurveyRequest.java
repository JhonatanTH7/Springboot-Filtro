package com.Surveys.SurveysManagement.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyRequest {

    @Schema(description = "Title of the survey", example = "Entry survey")
    @NotBlank(message = "The title is required")
    private String title;

    @Schema(description = "For what purpose the survey is being conducted", example = "Survey conducted on the person to collect information")
    @NotBlank(message = "The description is required")
    private String description;
    @Schema(description = "State of the survey (true or false)")
    @NotNull(message = "The status (active) is required - true or false")
    private boolean active;
    @Schema(description = "ID of the creator of the survey,value cannot be less than 1", example = "1")
    @NotNull(message = "The id of the creator is required")
    @Min(value = 1, message = "The id of the creator must be greater than zero")
    private Long idCreator;

}
