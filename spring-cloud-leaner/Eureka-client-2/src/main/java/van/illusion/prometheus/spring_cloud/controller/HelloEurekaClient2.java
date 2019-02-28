package van.illusion.prometheus.spring_cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import van.illusion.prometheus.spring_cloud.service.HelloService;

@RestController
public class HelloEurekaClient2 {

//    @Value("${hello}")
    private String hello;

    @Autowired
    private HelloService helloService;

    @GetMapping("/welcome")
    public Object welcome() {
        return "hello - client 2 - " + hello;
    }

    @GetMapping("/hello")
    public Object hello() {
        return helloService.hello();
    }

}
