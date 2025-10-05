import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DoctorService {

    public Map<String, Object> getAvailableTimeSlots(String doctorId, String date) {
        Map<String, Object> response = new HashMap<>();
        // Validate input
        if (doctorId == null || date == null) {
            response.put("error", "Doctor ID and date are required");
            return response;
        }

        // Placeholder for availability logic
        response.put("doctorId", doctorId);
        response.put("date", date);
        response.put("availableSlots", new String[]{"10:00 AM", "11:00 AM", "2:00 PM"});
        return response;
    }

    public Map<String, Object> validateDoctorLogin(String username, String password) {
        Map<String, Object> response = new HashMap<>();
        // Validate credentials (simplified for example)
        if (username == null || password == null) {
            response.put("error", "Username and password are required");
            return response;
        }

        // Placeholder for credential validation
        if ("doctor1".equals(username) && "pass123".equals(password)) {
            response.put("status", "success");
            response.put("message", "Login successful");
            response.put("doctorId", "doctor1");
        } else {
            response.put("error", "Invalid credentials");
        }
        return response;
    }
}
