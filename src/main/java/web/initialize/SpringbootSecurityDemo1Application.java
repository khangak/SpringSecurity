package web.initialize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableJpaRepositories
public class SpringbootSecurityDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSecurityDemo1Application.class, args);
	}

}
