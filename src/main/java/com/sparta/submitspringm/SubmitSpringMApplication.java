package com.sparta.submitspringm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SubmitSpringMApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubmitSpringMApplication.class, args);
    }

}
