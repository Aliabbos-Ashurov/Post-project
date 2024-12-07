package com.abbos.postproject.dto.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 19/November/2024  16:53
 **/
public record UserResponseDTO(
        @NotNull Long id,
        @NotNull @NotBlank String fullname,
        @NotNull @NotBlank String username
) implements Response {
}
