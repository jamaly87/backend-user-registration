package aj.projects.backenduserregistration.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
@Service
public class EmailValidator implements Predicate<String> {
    public final String EMAIL_PATTERN ="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

    @Override
    public boolean test(String s) {

        if (s.matches(EMAIL_PATTERN)){
            return true;
        }
        else {
            return false;
        }
    }
}
