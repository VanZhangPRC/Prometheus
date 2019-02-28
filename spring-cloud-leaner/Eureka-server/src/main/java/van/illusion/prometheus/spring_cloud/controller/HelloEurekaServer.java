package van.illusion.prometheus.spring_cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloEurekaServer {

    @GetMapping("/welcome")
    public Object welcome() {
        return "hello - configServer";
    }

}
