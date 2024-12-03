package com.abbos.postproject.dto;

import com.abbos.postproject.dto.request.Request;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 03/October/2024  12:32
 **/
public record TokenRequestDTO(
        @NotBlank @NotNull String username,
        @NotBlank @NotNull String password
) implements Request {
}
