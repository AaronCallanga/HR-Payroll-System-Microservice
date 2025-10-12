package com.hrps.authservice.service;

import com.hrps.authservice.dto.LoginRequestDTO;
import com.hrps.authservice.entity.Role;
import com.hrps.authservice.repository.RoleRepository;
import com.hrps.authservice.util.JwtUtil;
import io.jsonwebtoken.JwtException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class AuthService {

    private final UserService userService;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserService userService,
                       RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public Optional<String> authenticate(LoginRequestDTO loginRequestDTO) {
        Set<Role> roles = roleRepository.findByEmail(loginRequestDTO.getEmail());
        Optional<String> token = userService.findByEmail(loginRequestDTO.getEmail())
                                            .filter(u -> passwordEncoder.matches(loginRequestDTO.getPassword(), u.getPassword()))
                                            .map(u -> jwtUtil.generateToken(u.getEmail(), roles));

        return token;
    }

    public boolean validateToken(String token) {
        try {
            jwtUtil.validateToken(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}
