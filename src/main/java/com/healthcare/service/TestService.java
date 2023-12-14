package com.healthcare.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.healthcare.entity.DiagnosticCenter;
import com.healthcare.entity.Test;
import com.healthcare.exceptions.AdminException;
import com.healthcare.repo.DiagnosticCenterRepository;
import com.healthcare.repo.TestRepository;

@Service
public class TestService {

    @Autowired
    private DiagnosticCenterRepository diagnosticCenterRepository;

    @Autowired
    private TestRepository testRepository;

    @Autowired
    public TestService(DiagnosticCenterRepository diagnosticCenterRepository) {
        this.diagnosticCenterRepository = diagnosticCenterRepository;
    }

    public List<DiagnosticCenter> getDiagnosticCentersByCenterId(Long centerId) {
        return diagnosticCenterRepository.findByCenterId(centerId);
    }   

    @Transactional
    public String addTestToDiagnosticCenter(long centerId, Test test) throws AdminException {
        // Find the diagnostic center by ID
        Optional<DiagnosticCenter> optionalCenter = diagnosticCenterRepository.findById(centerId);

        if (optionalCenter.isPresent()) {
            DiagnosticCenter diagnosticCenter = optionalCenter.get();

            // Set the diagnostic center for the test
//            test.setDiagnosticCenter(diagnosticCenter);

            // Add the test to the diagnostic center's list of tests
            diagnosticCenter.getListOfTests().add(test);

            // Save changes to both entities
            diagnosticCenterRepository.save(diagnosticCenter);
//            testRepository.save(test);
            test.setDiagnosticCenter(diagnosticCenter);
            return "Test added to Diagnostic Center successfully.";
        } else {
            return "Diagnostic Center not found with ID: " + centerId;
        }
    }
    
    public void removeTestFromDiagnosticCenter(Long centerId, int testId) {
    	
        Optional<DiagnosticCenter> optionalDiagnosticCenter = diagnosticCenterRepository.findById(centerId);
        optionalDiagnosticCenter.ifPresent(diagnosticCenter -> {
            diagnosticCenter.getListOfTests().removeIf(test -> test.getTestId() == testId);
            diagnosticCenterRepository.save(diagnosticCenter);
            // Delete the Test entity from the database
            testRepository.deleteById((long) testId);
        });
    }
	/*
	 * public void removeTestFromDiagnosticCenter(Long centerId, int testId) {
	 * Optional<DiagnosticCenter> optionalDiagnosticCenter =
	 * diagnosticCenterRepository.findById(centerId);
	 * optionalDiagnosticCenter.ifPresent(diagnosticCenter -> {
	 * diagnosticCenter.getListOfTests().removeIf(test -> test.getTestId() ==
	 * testId); diagnosticCenterRepository.save(diagnosticCenter); }); }
	 */
}