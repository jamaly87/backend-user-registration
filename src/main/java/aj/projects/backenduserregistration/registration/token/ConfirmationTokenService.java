package aj.projects.backenduserregistration.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ConfirmationTokenService {

    private final IConfirmationRepository iConfirmationRepository;

    /**
     * Save Confirmation Token in our database.
     * @param token - ConfirmationToken
     */
    public void saveConfirmationToken (ConfirmationToken token){

        iConfirmationRepository.save(token);
    }

    /**
     * method to help us retrieve the token stored in the database
     * @param token - Confirmation Token
     * @return Confirmation Token in repo.
     */
    public Optional <ConfirmationToken> getToken (String token){
        return iConfirmationRepository.findByToken(token);
    }

    public int setConfirmedAt (String token){
        return iConfirmationRepository.updateConfirmedAt(token, LocalDateTime.now());
    }

}
