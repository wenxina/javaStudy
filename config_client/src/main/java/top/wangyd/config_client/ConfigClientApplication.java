package top.wangyd.config_client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigClientApplication {

	//@Value("${spring.mail.username}")
	@Value("${eureka.instance.hostname}")
	String username;

	@RequestMapping(value = "config")
	public String configTest(){
		return username;
	}

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
}
