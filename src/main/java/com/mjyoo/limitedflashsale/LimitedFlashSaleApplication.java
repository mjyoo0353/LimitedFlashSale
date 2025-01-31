package com.mjyoo.limitedflashsale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableJpaAuditing
@EnableScheduling
@SpringBootApplication
public class LimitedFlashSaleApplication {
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class) // Disable Spring Security

    public static void main(String[] args) {
        SpringApplication.run(LimitedFlashSaleApplication.class, args);
    }

}
