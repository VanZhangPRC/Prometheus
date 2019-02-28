package van.illusion.prometheus.spring_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import van.illusion.prometheus.spring_cloud.controller.HelloConfigClient1;

@SpringBootApplication
@Configuration
@ComponentScan(basePackageClasses = {HelloConfigClient1.class})
@EnableDiscoveryClient
public class ApplicationClient1 {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationClient1.class, args);
    }
}
