package com.healthcare.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.healthcare.entity.DiagnosticCenter;
import com.healthcare.entity.Test;
import com.healthcare.exceptions.AdminException;
import com.healthcare.service.DiagnosticCenterService;
import com.healthcare.service.TestService;

@RestController
@RequestMapping("/admin") 
public class AdminController {
	@Autowired
    private TestService testService;
    private final DiagnosticCenterService diagnosticCenterService;
    @Autowired
    public AdminController(TestService testService,DiagnosticCenterService diagnosticCenterService) {
        this.diagnosticCenterService = diagnosticCenterService;
		this.testService = testService;
    }
    @PostMapping("/add/{centerId}")
    public ResponseEntity<String> addTestToDiagnosticCenter(@PathVariable Long centerId,@RequestBody Test test)throws AdminException
    {
        String result = testService.addTestToDiagnosticCenter(centerId, test);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/centers/{centerId}")
    public List<DiagnosticCenter> getDiagnosticCentersByCenterId(@PathVariable Long centerId) {
        return diagnosticCenterService.getDiagnosticCentersByCenterId(centerId);
    }
    @DeleteMapping("/{centerId}/tests/{testId}")
    public ResponseEntity<String> removeTestFromDiagnosticCenter
    				(@PathVariable Long centerId,@PathVariable int testId) {
        testService.removeTestFromDiagnosticCenter(centerId, testId);
        return ResponseEntity.ok("Test removed from Diagnostic Center successfully");
    }
}