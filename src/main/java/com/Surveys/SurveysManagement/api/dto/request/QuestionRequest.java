package com.Surveys.SurveysManagement.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {

    @Schema(description = "Question statement", example = "what's your name?")
    @NotBlank(message = "The text is required")
    private String text;
    @Schema(description = "Type of the question (OPEN or CLOSED)", example = "OPEN")
    @Size(max = 50, message = "The type must have a maximum of 50 characters")
    private String type;
    @Schema(description = "State of the question (true or false)")
    @NotNull(message = "The status (active) is required - true or false")
    private boolean active;
    @Schema(description = "ID of the survey,value cannot be less than 1", example = "1")
    @NotNull(message = "The status (active) is required - true or false")
    private Long idSurvey;

}
