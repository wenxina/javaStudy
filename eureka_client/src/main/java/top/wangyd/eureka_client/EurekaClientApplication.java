package top.wangyd.eureka_client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @EnableEurekaClient表明自己是一个 eureka client
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication {

	/**
	 * 获取配置文件端口号
	 */
	@Value("${server.port}")
	private String port;

	@RequestMapping(value = "hi")
	public String test(@RequestParam(value = "name",defaultValue = "wangyd") String name){
		return "hi " + name + ";i am from " + port;
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
}
