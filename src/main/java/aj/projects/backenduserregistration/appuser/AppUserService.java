package aj.projects.backenduserregistration.appuser;

import aj.projects.backenduserregistration.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by: Alhamza Aljamaly
 * Date: March 20th, 2021
 * Notes: helps us retrieve a user from our database by querying the email.
 */
@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final IUserRepository iUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final static String USER_NOT_FOUND_ALERT = "User with email id %s is not found!";

    /**
     * Method to Return AppUser by providing the email address.
     * the IUserRepository interface provides access to the Database.
     * @param email address
     * @return AppUser details by querying the database using user email ID.
     * @throws UsernameNotFoundException -- if User isn't found.
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return iUserRepository.findByEmail(email)
                .orElseThrow(()->
                        new UsernameNotFoundException(String.format(USER_NOT_FOUND_ALERT,email)));
    }

    /**
     * sign up user by: 1- checking if the registration email exists or not.
     * 2- if it doesn't exist then the password will be encrypted and the result is set as the user's password
     * 3- the user then will be saved in the database/repository
     * @param appUser - application user details
     * @return
     */
    public String signUpUser (AppUser appUser){

        boolean userExists = iUserRepository.findByEmail(appUser.getEmail()).isPresent();
        if (userExists){
            throw new IllegalStateException("Email already taken!..Please enter a new email");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
        iUserRepository.save(appUser);

        //TODO: Send Confirmation Token

        return "it works";
    }
}
