package com.Surveys.SurveysManagement.api.dto.response.question;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionQuestionResponse {

    @Schema(description = "Id of the option")
    private Long idOptionQuestion;
    @Schema(description = "Statement of the option")
    private String text;
    @Schema(description = "status of the option")
    private boolean active;

}
