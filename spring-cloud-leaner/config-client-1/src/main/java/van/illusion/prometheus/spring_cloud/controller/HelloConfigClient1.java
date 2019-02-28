package van.illusion.prometheus.spring_cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloConfigClient1 {

//    @Value("${hello}")
    private String hello;

    @GetMapping("/welcome")
    public Object welcome() {

        return "hello - client 1 - " + hello;
    }

    @GetMapping("/")
    public Object welcomeAll() {
        return "hello - client 1 - " + hello;
    }

}
