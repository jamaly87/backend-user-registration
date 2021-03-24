package aj.projects.backenduserregistration.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by: Alhamza Aljamaly
 * Date: March 20th, 2021
 * Notes: User Application Class that implements UserDetails provided by Spring Security.
 */
@RestController
@RequestMapping (path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    @PostMapping
    public String register (@RequestBody RegistrationRequest request){

        return registrationService.register(request);
    }
}
