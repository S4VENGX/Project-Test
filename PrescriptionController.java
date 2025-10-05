import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PrescriptionController {

    public static class PrescriptionRequest {
        private String doctorId;
        private String patientId;
        private String medication;

        // Getters and setters
        public String getDoctorId() { return doctorId; }
        public void setDoctorId(String doctorId) { this.doctorId = doctorId; }
        public String getPatientId() { return patientId; }
        public void setPatientId(String patientId) { this.patientId = patientId; }
        public String getMedication() { return medication; }
        public void setMedication(String medication) { this.medication = medication; }
    }

    @PostMapping("/prescription/save")
    public ResponseEntity<Map<String, Object>> savePrescription(
            @RequestHeader("Authorization") String token,
            @RequestBody PrescriptionRequest request) {

        // Validate token
        if (token == null || !token.equals("validToken123")) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid or missing token");
            return ResponseEntity.status(401).body(errorResponse);
        }

        // Validate request body
        if (request.getDoctorId() == null || request.getPatientId() == null || request.getMedication() == null) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Missing required fields");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        // Save prescription logic (simplified for example)
        Map<String, Object> successResponse = new HashMap<>();
        successResponse.put("status", "success");
        successResponse.put("message", "Prescription saved successfully");
        successResponse.put("doctorId", request.getDoctorId());
        successResponse.put("patientId", request.getPatientId());
        successResponse.put("medication", request.getMedication());

        return ResponseEntity.ok(successResponse);
    }
}
