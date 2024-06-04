package com.Surveys.SurveysManagement.api.dto.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long idUser;
    private String name;
    private String email;
    private boolean active;

}
