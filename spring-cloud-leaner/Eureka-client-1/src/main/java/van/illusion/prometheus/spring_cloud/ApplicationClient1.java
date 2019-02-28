package van.illusion.prometheus.spring_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import van.illusion.prometheus.spring_cloud.controller.HelloEurekaClient1;
import van.illusion.prometheus.spring_cloud.service.HelloService;

@SpringBootApplication
@Configuration
@ComponentScan(basePackageClasses = {HelloEurekaClient1.class, HelloService.class})
//@EnableDiscoveryClient
@EnableEurekaClient
public class ApplicationClient1 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationClient1.class, args);
    }
}
