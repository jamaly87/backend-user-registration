package aj.projects.backenduserregistration.registration;

import aj.projects.backenduserregistration.appuser.AppUser;
import aj.projects.backenduserregistration.appuser.AppUserRole;
import aj.projects.backenduserregistration.appuser.AppUserService;
import aj.projects.backenduserregistration.registration.token.ConfirmationToken;
import aj.projects.backenduserregistration.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final AppUserService appUserService;
    private final ConfirmationTokenService confirmationTokenService;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail){
            throw new IllegalStateException("Invalid Email!");
        }
        return appUserService.signUpUser(new AppUser(
                request.getFirstName(), request.getLastName(),
                request.getEmail(), request.getPassword(), AppUserRole.USER
        ));
    }

    @Transactional
    public String confirmToken (String token){
        ConfirmationToken confirmationToken = confirmationTokenService.getToken(token).
                orElseThrow( ()-> new IllegalStateException("Token not found!"));
        if(confirmationToken.getConfirmedAt() != null){
            throw new IllegalStateException("Email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();
        if(expiredAt.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("Token is Expired!");
        }
        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(confirmationToken.getAppUser().getEmail());
        return "it works";

    }
}
