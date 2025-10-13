package com.hrps.authservice.service;

import com.hrps.authservice.dto.LoginRequestDTO;
import com.hrps.authservice.dto.RegisterRequestDTO;
import com.hrps.authservice.entity.Role;
import com.hrps.authservice.entity.User;
import com.hrps.authservice.repository.RoleRepository;
import com.hrps.authservice.repository.UserRepository;
import com.hrps.authservice.util.JwtUtil;
import io.jsonwebtoken.JwtException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public AuthService(UserService userService,
                       PasswordEncoder passwordEncoder, JwtUtil jwtUtil,
                       UserRepository userRepository1,
                       RoleRepository roleRepository) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository1;
        this.roleRepository = roleRepository;
    }

    public void register(RegisterRequestDTO registerRequestDTO) {
        Role role = roleRepository.findRoleByName(registerRequestDTO.getRole());
        User user = new User();
        user.setUsername(registerRequestDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        user.setEmail(registerRequestDTO.getEmail());
        user.setRoles(Set.of(role));

        userRepository.save(user);
    }

    public Optional<String> authenticate(LoginRequestDTO loginRequestDTO) {
        Optional<String> token = userService.findByEmail(loginRequestDTO.getEmail())
                                            .filter(u -> passwordEncoder.matches(loginRequestDTO.getPassword(), u.getPassword()))
                                            .map(u -> jwtUtil.generateToken(u.getEmail(), u.getRoles()));

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
