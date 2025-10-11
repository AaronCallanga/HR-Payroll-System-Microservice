package com.hrps.performancereviewservice.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class PerformanceReviewRequestDTO {
    @NotNull(message = "Employee ID is required")
    private UUID employeeId;

    @NotBlank(message = "Review period is required")
    @Pattern(
            regexp = "^(Initial Evaluation|Probation Review|Mid-Year Review|Annual Review|Project-Based Review)$",
            message = "Review period must be one of: Initial Evaluation, Probation Review, Mid-Year Review, Annual Review, Project-Based Review"
    )
    private String reviewPeriod;

    @NotBlank(message = "Reviewer name is required")
    @Size(max = 100, message = "Reviewer name must not exceed 100 characters")
    private String reviewer;

    @DecimalMin(value = "0.0", inclusive = true, message = "Score cannot be negative")
    @DecimalMax(value = "5.0", inclusive = true, message = "Score cannot exceed 5.0")
    private Double score;

    @Size(max = 1000, message = "Comments cannot exceed 1000 characters")
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
