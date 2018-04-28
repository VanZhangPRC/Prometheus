package kraken.hermes.web.controller;

import kraken.hermes.jpa.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/mail")
public class MailSenderController {

    @Autowired
    private MailService mailService;


    @RequestMapping(path = "/send")
    public Object send() {
        mailService.sendTest();
        return "send";
    }

}
