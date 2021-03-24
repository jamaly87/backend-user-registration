package aj.projects.backenduserregistration.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
@Service
public class EmailValidator implements Predicate<String> {

    @Override
    public boolean test(String s) {
        // TODO: in order to activate it, we need to add a Regex for email validation
        return true;
    }
}
