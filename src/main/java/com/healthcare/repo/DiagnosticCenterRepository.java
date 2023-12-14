package com.healthcare.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.entity.DiagnosticCenter;

public interface DiagnosticCenterRepository extends JpaRepository<DiagnosticCenter, Long> {
    List<DiagnosticCenter> findByCenterId(Long centerId);

}
