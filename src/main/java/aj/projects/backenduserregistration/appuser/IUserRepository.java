package aj.projects.backenduserregistration.appuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * Created by: Alhamza Aljamaly
 * Date: March 20th, 2021
 * Notes:
 */
@Repository
@Transactional (readOnly = true)
//JpaRepository takes AppUser class and id type Long as declared in the AppUser class
public interface IUserRepository extends JpaRepository <AppUser,Long> {

    //abstract method to return AppUser by providing an email
    Optional<AppUser> findByEmail (String email); //to avoid null pointer exception

    @Transactional
    @Modifying
    @Query("UPDATE AppUser a "+"SET a.enabled=TRUE WHERE a.email= ?1")
    int enableAppUser (String email);
}
