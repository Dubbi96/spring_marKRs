package pe.veriestate.asan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@SpringBootConfiguration
@EnableJpaAuditing
@EnableWebSecurity
public class AsanApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsanApplication.class, args);
	}

}
