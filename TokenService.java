import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    private static final String SECRET_KEY = "your-very-secure-secret-key"; // Should be configured in application.properties
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days in milliseconds

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, getSigningKey())
                .compact();
    }

    public String getSigningKey() {
        return SECRET_KEY; // In a real application, this should be retrieved from configuration
    }
}
