package kraken.pheidippides.web.controller;

import kraken.basic.KrakenBasicConfig;
import kraken.hermes.HermesConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "kraken.pandora.service")
@EntityScan(basePackages = "kraken.pandora.orm")
@EnableJpaRepositories(basePackages = "kraken.pandora.repository")
@Import(value = {KrakenBasicConfig.class, HermesConfig.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
