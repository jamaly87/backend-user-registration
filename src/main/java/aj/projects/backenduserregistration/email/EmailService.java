package aj.projects.backenduserregistration.email;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender{
    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    private JavaMailSender javaMailSender;
    @Override
    public void send(String to, String email) {
        try {
            //TODO: write business logic to send email.

        } catch (MessagingException e){
            LOGGER.error("Failed to Send Email!",e);
            throw new IllegalStateException("Failed to Send Email");
        }

    }
}
