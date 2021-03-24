package aj.projects.backenduserregistration.registration;

import aj.projects.backenduserregistration.appuser.AppUser;
import aj.projects.backenduserregistration.appuser.AppUserRole;
import aj.projects.backenduserregistration.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final AppUserService appUserService;

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
}
