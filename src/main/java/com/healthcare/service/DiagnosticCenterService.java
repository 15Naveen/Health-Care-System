package com.healthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.entity.DiagnosticCenter;
import com.healthcare.repo.DiagnosticCenterRepository;

@Service
public class DiagnosticCenterService {
	private final DiagnosticCenterRepository diagnosticCenterRepository;

    @Autowired
    public DiagnosticCenterService(DiagnosticCenterRepository diagnosticCenterRepository) {
        this.diagnosticCenterRepository = diagnosticCenterRepository;
    }

    public List<DiagnosticCenter> getDiagnosticCentersByCenterId(Long centerId) {
        return diagnosticCenterRepository.findByCenterId(centerId);
    }   
}