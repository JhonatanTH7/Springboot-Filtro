package com.Surveys.SurveysManagement.api.dto.response.question;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {

    private Long idQuestion;
    private String text;
    private String type;
    private boolean active;
    private List<OptionQuestionResponse> options;

}
