package van.illusion.prometheus.spring_cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import van.illusion.prometheus.spring_cloud.service.HelloService;

@RestController
public class HelloEurekaClient1 {

//    @Value("${hello}")
    private String hello;

    @Autowired
    private HelloService helloService;

    @GetMapping("/welcome")
    public Object welcome() {
        return "hello - client 1 - " + hello;
    }

    @GetMapping("/helloService")
    public Object helloService() {
        return  helloService.hello();
    }

}
