package kraken.hermes.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendTest() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("3129006005@qq.com");
        simpleMailMessage.setTo("659595570@qq.com");
        simpleMailMessage.setText("Hello World");
        simpleMailMessage.setSubject("HelloWorld!");

        try {
            mailSender.send(simpleMailMessage);
        } catch (MailException e) {
            e.printStackTrace();
        }
        System.out.println("done");
    }

}
