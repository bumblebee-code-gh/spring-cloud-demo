package org.example.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConsumerDemoConfig {

	@Bean
	// 这个注解让RestTemplate有负载均衡的功能，通过调用Ribbon访问provider-demo集群
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
