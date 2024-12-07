package com.abbos.postproject.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author Aliabbos Ashurov
 * @since 19/November/2024  16:55
 **/
public record UserUpdateDTO(
        @NotNull @NotBlank String fullname,
        @NotNull @NotBlank String username,
        @NotNull @NotBlank String password
) implements Request {
}
