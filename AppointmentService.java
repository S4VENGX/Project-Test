import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public boolean bookAppointment(String doctorId, String patientId, String dateTime) {
        // Create a new appointment instance
        Appointment appointment = new Appointment();
        appointment.setDoctorId(doctorId);
        appointment.setPatientId(patientId);
        appointment.setDateTime(dateTime);

        // Save appointment to repository
        appointmentRepository.save(appointment);
        return true; // Indicate success
    }

    public List<String> getAppointmentsForDoctor(String doctorId, String date) {
        // Retrieve appointments for the given doctor and date
        List<Appointment> appointments = appointmentRepository.findByDoctorIdAndDate(doctorId, date);
        return appointments.stream()
                .map(Appointment::getDateTime)
                .toList();
    }
}

// Placeholder Appointment entity (for completeness)
class Appointment {
    private String doctorId;
    private String patientId;
    private String dateTime;

    // Getters and setters
    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    public String getDateTime() { return dateTime; }
    public void setDateTime(String dateTime) { this.dateTime = dateTime; }
}

// Placeholder AppointmentRepository (for completeness)
interface AppointmentRepository {
    void save(Appointment appointment);
    List<Appointment> findByDoctorIdAndDate(String doctorId, String date);
}
