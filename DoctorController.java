import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DoctorController {

    @GetMapping("/api/users/{user}/doctors/{doctorId}/availability/{date}/{token}")
    public ResponseEntity<Map<String, Object>> getDoctorAvailability(
            @PathVariable String user,
            @PathVariable String doctorId,
            @PathVariable String date,
            @PathVariable String token) {

        Map<String, Object> response = new HashMap<>();

        // Validate token
        if (token == null || token.isEmpty()) {
            response.put("error", "Token is required");
            return ResponseEntity.status(401).body(response);
        }

        if (!isValidToken(token)) {
            response.put("error", "Invalid token");
            return ResponseEntity.status(401).body(response);
        }

        // Validate user role
        if (!isValidUserRole(user)) {
            response.put("error", "Unauthorized user role");
            return ResponseEntity.status(403).body(response);
        }

        // Check doctor availability
        String availability = getAvailability(doctorId, date);
        response.put("status", "success");
        response.put("doctorId", doctorId);
        response.put("date", date);
        response.put("available", availability);

        return ResponseEntity.ok(response);
    }

    private boolean isValidToken(String token) {
        // Simplified token validation (e.g., check against a secret key)
        return "validToken123".equals(token);
    }

    private boolean isValidUserRole(String user) {
        // Simplified role validation (e.g., check if user is 'admin' or 'patient')
        return "admin".equals(user) || "patient".equals(user);
    }

    private String getAvailability(String doctorId, String date) {
        // Placeholder for availability logic (e.g., check database)
        return "true"; // Example response
    }
}
