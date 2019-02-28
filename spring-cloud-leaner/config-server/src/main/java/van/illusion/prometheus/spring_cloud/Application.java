package van.illusion.prometheus.spring_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import van.illusion.prometheus.spring_cloud.controller.HelloConfigServer;

@SpringBootApplication
@Configuration
@ComponentScan(basePackageClasses = {HelloConfigServer.class})
@EnableConfigServer
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
