package van.illusion.prometheus.spring_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import van.illusion.prometheus.spring_cloud.controller.HelloEurekaGateway;

@SpringBootApplication
@Configuration
@ComponentScan(basePackageClasses = {HelloEurekaGateway.class})
@EnableZuulProxy
public class EurekaGateway {
    public static void main(String[] args) {
        SpringApplication.run(EurekaGateway.class, args);
    }
}
