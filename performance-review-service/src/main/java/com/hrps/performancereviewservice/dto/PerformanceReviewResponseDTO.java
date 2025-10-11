package com.hrps.performancereviewservice.dto;

import java.util.UUID;

public class PerformanceReviewResponseDTO {
    private Long id;
    private UUID employeeId;
    private String reviewPeriod;
    private String reviewer;
    private Double score;
    private String comments;
    private String status;

    public PerformanceReviewResponseDTO() {
    }

    public PerformanceReviewResponseDTO(Long id,
                                        UUID employeeId,
                                        String reviewPeriod,
                                        String reviewer,
                                        Double score,
                                        String comments,
                                        String status) {
        this.id = id;
        this.employeeId = employeeId;
        this.reviewPeriod = reviewPeriod;
        this.reviewer = reviewer;
        this.score = score;
        this.comments = comments;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    public String getReviewPeriod() {
        return reviewPeriod;
    }

    public void setReviewPeriod(String reviewPeriod) {
        this.reviewPeriod = reviewPeriod;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
