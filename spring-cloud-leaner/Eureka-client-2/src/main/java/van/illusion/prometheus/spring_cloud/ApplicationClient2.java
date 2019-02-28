package van.illusion.prometheus.spring_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import van.illusion.prometheus.spring_cloud.controller.HelloEurekaClient2;
import van.illusion.prometheus.spring_cloud.service.HelloService;

@SpringBootApplication
@Configuration
@ComponentScan(basePackageClasses = {HelloEurekaClient2.class, HelloService.class})
//@EnableDiscoveryClient
@EnableEurekaClient
public class ApplicationClient2 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationClient2.class, args);
    }
}
