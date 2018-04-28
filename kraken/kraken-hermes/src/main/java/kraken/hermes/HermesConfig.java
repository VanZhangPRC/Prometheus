package kraken.hermes;

import kraken.hermes.jpa.service.MailService;
import kraken.hermes.web.controller.Responder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {Responder.class, MailService.class})
public class HermesConfig {
}
