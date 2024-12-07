package com.abbos.postproject.service;

import com.abbos.postproject.dto.Response;
import com.abbos.postproject.dto.TokenResponseDTO;
import com.abbos.postproject.exception.TokenExpiredException;
import com.abbos.postproject.exception.UserNotFoundException;
import com.abbos.postproject.repository.UserRepository;
import com.abbos.postproject.util.JwtTokenUtils;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final UserRepository userRepository;
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;

    public Response<TokenResponseDTO> generateToken(@NotNull String username, @NotNull String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        var user = userRepository.findByUsername(username);
        var accessToken = jwtTokenUtils.generateAccessToken(user.getId(), user.getUsername());
        var refreshToken = jwtTokenUtils.generateRefreshToken(user.getUsername());
        return Response.ok(TokenResponseDTO.of(user.getId(), accessToken, refreshToken));
    }

    public Response<TokenResponseDTO> refreshToken(@NotNull String refreshToken) {
        if (!jwtTokenUtils.validateToken(refreshToken))
            throw new TokenExpiredException("Token has expired or invalid: {0}", refreshToken);
        var username = jwtTokenUtils.extractUsername(refreshToken);
        var user = userRepository.findByUsername(username);
        if (user == null)
            throw new UserNotFoundException("User not found: {0}", username);
        var newAccessToken = jwtTokenUtils.generateAccessToken(user.getId(), user.getUsername());
        var newRefreshToken = jwtTokenUtils.generateRefreshToken(user.getUsername());
        return Response.ok(TokenResponseDTO.of(user.getId(), newAccessToken, newRefreshToken));
    }
}