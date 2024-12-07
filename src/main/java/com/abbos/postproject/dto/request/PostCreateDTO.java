package com.abbos.postproject.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 19/November/2024  17:03
 **/
public record PostCreateDTO(
        @NotNull @NotBlank String title,
        @NotNull @NotBlank String content
) implements Request {
}
