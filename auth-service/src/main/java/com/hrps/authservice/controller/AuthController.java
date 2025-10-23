package com.hrps.authservice.controller;

import com.hrps.authservice.dto.LoginRequestDTO;
import com.hrps.authservice.dto.LoginResponseDTO;
import com.hrps.authservice.dto.RegisterRequestDTO;
import com.hrps.authservice.service.AuthService;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    //@Operation(summary = "Generate token on user login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        Optional<String> optionalToken = authService.authenticate(loginRequestDTO);

        if (optionalToken.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String token = optionalToken.get();
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDTO registerRequestDTO) {
        authService.register(registerRequestDTO);
        return ResponseEntity.ok("CREATED");
    }

    @GetMapping("/validate")
    //@Operation(summary = "Validate Token")
    public ResponseEntity<Void> validateToken(@RequestHeader("Authorization") String authHeader) { // Extract the header "Authorization"
        // Authorization: Bearer <token>

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String token = authHeader.substring(7);

        return authService.validateToken(token) ?
                ResponseEntity.ok().build() : ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/test-limiter")
    public ResponseEntity<String> testLimiter() {
            try {
                Thread.sleep(20000);
                System.out.println("TEST");
            } catch (InterruptedException e) {
                System.out.println("Task cancelled!");
                Thread.currentThread().interrupt();
            }
            return ResponseEntity.ok("TEST");
    }

    @GetMapping("/test-limiter")
    public ResponseEntity<String> testRetry() {
        System.out.println("TEST: " + LocalDateTime.now());
        return ResponseEntity.internalServerError().build();
    }


}

