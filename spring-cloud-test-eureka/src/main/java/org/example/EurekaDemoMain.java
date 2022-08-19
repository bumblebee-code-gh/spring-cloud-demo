package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// 启用Eureka服务器端功能
@EnableEurekaServer
@SpringBootApplication
public class EurekaDemoMain {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EurekaDemoMain.class, args);
	}

}
