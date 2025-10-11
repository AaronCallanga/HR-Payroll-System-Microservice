package com.hrps.performancereviewservice.service;

import com.hrps.performancereviewservice.dto.PerformanceReviewRequestDTO;
import com.hrps.performancereviewservice.dto.PerformanceReviewResponseDTO;
import com.hrps.performancereviewservice.entity.PerformanceReview;
import com.hrps.performancereviewservice.mapper.PerformanceReviewMapper;
import com.hrps.performancereviewservice.repository.PerformanceReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PerformanceReviewService {

    private final PerformanceReviewRepository repository;

    public PerformanceReviewService(PerformanceReviewRepository repository) {
        this.repository = repository;
    }

    /** Initializes a default performance review for newly created employee */
    // Called by Kafka consumer
    public void initializePerformanceReview(UUID employeeId) {
        PerformanceReviewRequestDTO request = new PerformanceReviewRequestDTO();
        request.setEmployeeId(employeeId);
        request.setReviewPeriod("Initial Evaluation");
        request.setReviewer("HR System");
        request.setScore(0.0);
        request.setComments("Auto-generated initial review record");

        repository.save(PerformanceReviewMapper.toEntity(request));
    }

    /** Creates a custom review record */
    public PerformanceReviewResponseDTO createReview(PerformanceReviewRequestDTO request) {
        PerformanceReview review = repository.save(PerformanceReviewMapper.toEntity(request));
        return PerformanceReviewMapper.toResponse(review);
    }

    public List<PerformanceReviewResponseDTO> getAllReviews() {
        List<PerformanceReview> reviews = repository.findAll();
        return PerformanceReviewMapper.toListResponse(reviews);
    }


    // Create other operation, and admin update status after giving review
}
