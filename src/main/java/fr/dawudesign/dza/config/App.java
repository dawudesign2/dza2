package fr.dawudesign.dza.config;

import fr.dawudesign.dza.exeptions.WebErrorMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {

    @Bean
    public WebErrorMapper webErrorMapper() {
        return new WebErrorMapper();
    }
}
