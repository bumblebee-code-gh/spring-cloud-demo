package org.example.controller;

import org.example.api.UserRemoteService;
import org.example.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.example.entity.User;

@RestController
public class ConsumerController {

	@Autowired
	private RestTemplate restTemplate;

	// 装配调用远程微服务的接口，后面像调用本地方法一样直接使用
	@Autowired
	private UserRemoteService userRemoteService;

	@RequestMapping("/consumer/get/user")
	public User getUserRemote() {

		// 1.声明远程微服务的主机地址加端口号
		// String host = "http://localhost:1000";

		// 1.将远程微服务调用地址从“IP地址+端口号”改成“微服务名称”
		String host = "http://provider-demo";

		// 2.声明具体要调用的功能的url地址
		String url = "/provider/get/user";

		// 3.通过RestTemplate调用远程微服务
		return restTemplate.getForObject(host + url, User.class);
	}

	@RequestMapping("/consumer/get/user/feign")
	public User getUserByFeign() {
		return userRemoteService.getUserByFeign();
	}

	@RequestMapping("/consumer/get/user/hystrix")
	public ResultEntity<User> getUserByHystrix(@RequestParam("signal") String signal) {
		return userRemoteService.getUserByHystrix(signal);
	}
}
