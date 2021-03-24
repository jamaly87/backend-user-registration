package aj.projects.backenduserregistration.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

}
