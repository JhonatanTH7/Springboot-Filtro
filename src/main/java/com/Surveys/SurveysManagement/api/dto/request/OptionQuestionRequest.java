package com.Surveys.SurveysManagement.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionQuestionRequest {

    @Schema(description = "Question option", example = "4")
    @NotBlank(message = "The text is required")
    private String text;
    @Schema(description = "State of the option (true or false)")
    @NotNull(message = "The status (active) is required - true or false")
    private boolean active;

}
