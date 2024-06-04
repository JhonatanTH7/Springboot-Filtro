package com.Surveys.SurveysManagement.api.dto.response.question;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {

    @Schema(description = "Id of the question")
    private Long idQuestion;
    @Schema(description = "Question statement")
    private String text;
    @Schema(description = "Type of the question")
    private String type;
    @Schema(description = "Status of the question")
    private boolean active;
    @Schema(description = "Options list")
    private List<OptionQuestionResponse> options;

}
