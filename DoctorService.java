import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    public List<String> getAvailableTimeSlots(String doctorId, LocalDate date) {
        // Validate input
        if (doctorId == null || date == null) {
            return new ArrayList<>(); // Return empty list for invalid input
        }

        // Placeholder for availability logic
        List<String> availableSlots = new ArrayList<>();
        if (date.isEqual(LocalDate.now())) { // Example for current date: 2025-10-05
            availableSlots.add("10:00 AM");
            availableSlots.add("11:00 AM");
            availableSlots.add("2:00 PM");
        }
        return availableSlots;
    }

    public Map<String, Object> validateDoctorLogin(String username, String password) {
        Map<String, Object> response = new HashMap<>();
        if (username == null || password == null) {
            response.put("error", "Username and password are required");
            return response;
        }

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
