package userRegistration.com.demo.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import userRegistration.com.demo.entity.User;

@SpringBootApplication(scanBasePackages = "userRegistration.com.demo")
@EntityScan(basePackageClasses = User.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
