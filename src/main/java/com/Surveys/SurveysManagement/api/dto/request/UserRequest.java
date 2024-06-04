package com.Surveys.SurveysManagement.api.dto.request;

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

    @NotBlank(message = "The name is required")
    @Size(max = 100, message = "The name must have a maximum of 100 characters")
    private String name;

    @NotBlank(message = "The email is required")
    @Size(max = 100, message = "The email must have a maximum of 100 characters")
    private String email;

    @NotBlank(message = "The password is required")
    private String password;

    @NotNull(message = "The status (active) is required - true or false")
    private boolean active;

}
