package boardSpringProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BoardSpringModelProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(BoardSpringModelProjectApplication.class, args);
	}
}
