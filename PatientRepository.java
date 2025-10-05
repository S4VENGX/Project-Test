import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Derived query to find patient by email
    Optional<Patient> findByEmail(String email);

    // Custom query to find patient by email or phone number
    @Query("SELECT p FROM Patient p WHERE p.email = :email OR p.phoneNumber = :phoneNumber")
    Optional<Patient> findByEmailOrPhoneNumber(String email, String phoneNumber);
}

// Assuming Patient entity (for completeness, though not required in repository)
class Patient {
    private Long id;
    private String email;
    private String phoneNumber;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
