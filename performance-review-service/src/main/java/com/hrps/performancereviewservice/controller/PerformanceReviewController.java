package com.hrps.performancereviewservice.controller;

import com.hrps.performancereviewservice.dto.PerformanceReviewRequestDTO;
import com.hrps.performancereviewservice.dto.PerformanceReviewResponseDTO;
import com.hrps.performancereviewservice.service.PerformanceReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/performance-reviews")
public class PerformanceReviewController {

    private final PerformanceReviewService performanceReviewService;

    public PerformanceReviewController(PerformanceReviewService performanceReviewService) {
        this.performanceReviewService = performanceReviewService;
    }

    @PostMapping
    public ResponseEntity<PerformanceReviewResponseDTO> createPerformanceReview(@RequestBody PerformanceReviewRequestDTO performanceReviewRequestDTO) {
        return ResponseEntity.ok(performanceReviewService.createReview(performanceReviewRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<PerformanceReviewResponseDTO>> getPerformanceReviews() {
        return ResponseEntity.ok(performanceReviewService.getAllReviews());
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<List<PerformanceReviewResponseDTO>> getPerformanceReview(@PathVariable UUID employeeId) {
        return ResponseEntity.ok(performanceReviewService.getAllReviewsByEmployeeId(employeeId));
    }
}
