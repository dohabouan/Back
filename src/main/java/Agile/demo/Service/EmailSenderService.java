package Agile.demo.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender javaMailSender;
    public void SendEmail(String toEmail,String body,String subject) throws MessagingException {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setFrom("Bouanane.doha@gmail.com");
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(body);
        javaMailSender.send(mimeMessage);

    }
}

