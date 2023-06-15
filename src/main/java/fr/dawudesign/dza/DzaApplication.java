package fr.dawudesign.dza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DzaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DzaApplication.class, args);
    }

}
