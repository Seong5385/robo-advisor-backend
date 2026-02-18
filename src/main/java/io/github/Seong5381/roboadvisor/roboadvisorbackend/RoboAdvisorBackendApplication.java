package io.github.Seong5381.roboadvisor.roboadvisorbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RoboAdvisorBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoboAdvisorBackendApplication.class, args);
    }

}
