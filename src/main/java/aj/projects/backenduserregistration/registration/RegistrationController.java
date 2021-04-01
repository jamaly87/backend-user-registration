package aj.projects.backenduserregistration.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Created by: Alhamza Aljamaly
 * Date: March 20th, 2021
 * Notes: User Application Class that implements UserDetails provided by Spring Security.
 */
@RestController
@RequestMapping (path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register (@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm (@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }

}
