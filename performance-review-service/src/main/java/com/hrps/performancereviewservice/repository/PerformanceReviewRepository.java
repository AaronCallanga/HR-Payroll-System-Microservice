package com.hrps.performancereviewservice.repository;

import com.hrps.performancereviewservice.entity.PerformanceReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PerformanceReviewRepository extends JpaRepository<PerformanceReview, Long> {
}
