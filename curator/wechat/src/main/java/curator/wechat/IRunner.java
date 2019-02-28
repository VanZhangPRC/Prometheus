package curator.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"curator.wechat.service", "curator.wechat.web"})
@EntityScan(basePackages = "curator.wechat.entity")
@EnableJpaRepositories(basePackages = "curator.wechat.repository")
public class IRunner {
    public static void main(String[] args) {
        SpringApplication.run(IRunner.class, args);
    }
}
