/*
 * package com.healthcare.service;
 * 
 * import java.util.List; import java.util.Optional; import java.util.Scanner;
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service; import
 * org.springframework.transaction.annotation.Transactional; import
 * com.healthcare.entity.DiagnosticCenter; import com.healthcare.entity.Test;
 * import com.healthcare.repo.TestRepository;
 * 
 * @Service public class TestServices {
 * 
 * @Autowired private TestRepository testRepository;
 * 
 * @Autowired DiagnosticCenter diagnosticCenters; public static String
 * addTest(Test test) { return "Test Added"; } private DiagnosticCenter
 * chooseDiagnosticCenter() { //list and choose the DiagnosticCenter
 * List<DiagnosticCenter> diagnosticCenters = getDiagnosticCenters();
 * displayDiagnosticCenters(diagnosticCenters); int choice =
 * getUserChoice(diagnosticCenters.size()); Optional<DiagnosticCenter>
 * optionalCenter = diagnosticCenters.stream() .filter(center ->
 * center.getCenterId() == choice) .findFirst(); return
 * optionalCenter.orElseThrow(() -> new
 * IllegalArgumentException("Invalid choice")); }
 * 
 * private void displayDiagnosticCenters(List<DiagnosticCenter>
 * diagnosticCenters) { System.out.println("Choose a diagnostic center:");
 * diagnosticCenters.forEach(center -> System.out.println(center.getCenterId() +
 * ". " + center.getCenterName())); }
 * 
 * private int getUserChoice(int maxChoice) { Scanner sc = new
 * Scanner(System.in); int choice; do { System.out.print("Enter your choice (1-"
 * + maxChoice + "): "); choice = sc.nextInt(); } while (choice < 1 || choice >
 * maxChoice); return choice; }
 * 
 * private List<DiagnosticCenter> getDiagnosticCenters() { return null; }
 * 
 * private void createTest(int testId, String testName) { Test test=new Test();
 * test.setTestId(testId); test.setTestName(testName); }
 * 
 * @Transactional(readOnly=false) public boolean removeTest(long testId) {
 * //view and choose the center chooseDiagnosticCenter();
 * 
 * //view and choose the test
 * 
 * //delete the selected test long count=testRepository.count();
 * testRepository.deleteById(testId); if( count>testRepository.count()) return
 * true; return "Test Not Found" != null; //throw new
 * TestNotFoundException("Product with id "+centerId+"Not found to Delete"); } }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * DiagnosticCenter diagnosticCenter =
 * diagnosticCenterRepository.findById(centerId) .orElseThrow(() -> new
 * ResourceNotFoundException("Diagnostic Center not found"));
 * 
 * List<Test> tests = diagnosticCenter.getTests(); tests.removeIf(test ->
 * test.getId().equals(testId));
 * 
 * diagnosticCenterRepository.save(diagnosticCenter); }
 */