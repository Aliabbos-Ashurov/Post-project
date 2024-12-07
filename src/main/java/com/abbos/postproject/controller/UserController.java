package com.abbos.postproject.controller;

import com.abbos.postproject.dto.Response;
import com.abbos.postproject.dto.response.UserResponseDTO;
import com.abbos.postproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aliabbos Ashurov
 * @since 19/November/2024  16:58
 **/
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<Response<UserResponseDTO>> getMe() {
        return ResponseEntity.ok(userService.getMe());
    }
}
