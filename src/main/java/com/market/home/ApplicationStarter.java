package com.market.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.market.home")
@EnableJpaRepositories("com.market.home.repository")
@EntityScan(basePackages = {"com.market.home"})
public class ApplicationStarter extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ApplicationStarter.class);
    }
}
