package com.hrps.performancereviewservice.mapper;

import com.hrps.performancereviewservice.dto.PerformanceReviewRequestDTO;
import com.hrps.performancereviewservice.dto.PerformanceReviewResponseDTO;
import com.hrps.performancereviewservice.entity.PerformanceReview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PerformanceReviewMapper {

    // Convert request to entity
    public static PerformanceReview toEntity(PerformanceReviewRequestDTO request) {
        PerformanceReview review = new PerformanceReview();
        review.setEmployeeId(request.getEmployeeId());
        review.setReviewPeriod(request.getReviewPeriod());
        review.setReviewer(request.getReviewer());
        review.setScore(request.getScore());
        review.setComments(request.getComments());
        review.setStatus("PENDING");
        return review;
    }

    // Convert entity to response
    public static PerformanceReviewResponseDTO toResponse(PerformanceReview review) {
        PerformanceReviewResponseDTO res = new PerformanceReviewResponseDTO();
        res.setId(review.getId());
        res.setEmployeeId(review.getEmployeeId());
        res.setReviewPeriod(review.getReviewPeriod());
        res.setReviewer(review.getReviewer());
        res.setScore(review.getScore());
        res.setComments(review.getComments());
        res.setStatus(review.getStatus());
        return res;
    }

    // Convert a List of PerformanceReview entities to List of PerformanceReviewResponseDTO
    public static List<PerformanceReviewResponseDTO> toListResponse(List<PerformanceReview> reviews) {
        return reviews.stream()
                      .map(PerformanceReviewMapper::toResponse)
                      .collect(Collectors.toList());
    }
}
