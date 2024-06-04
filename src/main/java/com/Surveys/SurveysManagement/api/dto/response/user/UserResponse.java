package com.Surveys.SurveysManagement.api.dto.response.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    @Schema(description = "Id of the user")
    private Long idUser;
    @Schema(description = "Name of the user")
    private String name;
    @Schema(description = "Email of the user")
    private String email;
    @Schema(description = "Status of the user")
    private boolean active;

}
