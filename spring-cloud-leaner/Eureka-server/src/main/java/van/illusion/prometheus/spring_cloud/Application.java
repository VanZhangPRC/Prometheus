package van.illusion.prometheus.spring_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import van.illusion.prometheus.spring_cloud.controller.HelloEurekaServer;

@SpringBootApplication
@Configuration
@ComponentScan(basePackageClasses = {HelloEurekaServer.class})
@EnableEurekaServer
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
