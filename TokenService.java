import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${jwt.secret.key}")
    private String secretKey; // Retrieved from environment variables or application.properties

    private static final long EXPIRATION_TIME = 864_000_000; // 10 days in milliseconds

    /**
     * Generates a JWT token for the given email.
     * @param email The email of the user
     * @return A JWT token string
     */
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, getSigningKey())
                .compact();
    }

    /**
     * Retrieves the signing key for JWT token generation.
     * @return The secret key configured in the environment
     */
    public String getSigningKey() {
        return secretKey;
    }
}
