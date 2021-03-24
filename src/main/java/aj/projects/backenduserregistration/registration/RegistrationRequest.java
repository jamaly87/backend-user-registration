package aj.projects.backenduserregistration.registration;
/**
 * Created by: Alhamza Aljamaly
 * Date: March 20th, 2021
 * Notes: User Registration Request Obj
 */

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString

public class RegistrationRequest {
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String email;
}
