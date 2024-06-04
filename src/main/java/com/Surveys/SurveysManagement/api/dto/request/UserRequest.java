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
public class UserRequest {

    @Schema(description = "Name of the user", example = "Jhonatan Toro")
    @NotBlank(message = "The name is required")
    @Size(max = 100, message = "The name must have a maximum of 100 characters")
    private String name;

    @Schema(description = "Email of the user", example = "pepito_perez90@gmail.com")
    @NotBlank(message = "The email is required")
    @Size(max = 100, message = "The email must have a maximum of 100 characters")
    private String email;

    @Schema(description = "Password of the user", example = "pepito_perez90*123")
    @NotBlank(message = "The password is required")
    private String password;

    @Schema(description = "State of the user (true or false)")
    @NotNull(message = "The status (active) is required - true or false")
    private boolean active;

}
