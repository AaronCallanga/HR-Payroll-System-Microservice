package com.hrps.performancereviewservice.dto;

import java.util.UUID;

public class PerformanceReviewRequestDTO {
    private UUID employeeId;
    private String reviewPeriod;
    private String reviewer;
    private Double score;
    private String comments;

    public PerformanceReviewRequestDTO() {
    }

    public PerformanceReviewRequestDTO(UUID employeeId,
                                       String reviewPeriod,
                                       String reviewer,
                                       Double score,
                                       String comments) {
        this.employeeId = employeeId;
        this.reviewPeriod = reviewPeriod;
        this.reviewer = reviewer;
        this.score = score;
        this.comments = comments;
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
}
