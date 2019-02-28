package van.illusion.prometheus.spring_cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

@RestController
public class HelloEurekaGateway {

    @GetMapping("/welcome")
    public Object welcome() {
        return "hello - EurekaGateway";
    }

}
