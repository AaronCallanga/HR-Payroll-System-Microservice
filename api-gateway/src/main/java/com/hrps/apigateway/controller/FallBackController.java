package com.hrps.apigateway.controller;

import org.springframework.cloud.gateway.filter.ratelimit.PrincipalNameKeyResolver;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackController {
    @RequestMapping
    public ResponseEntity<String> fallback() {
        return ResponseEntity.internalServerError().body("Internal Server Error");
    }
}