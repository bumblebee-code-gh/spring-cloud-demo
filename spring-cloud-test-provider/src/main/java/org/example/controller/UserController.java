package org.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.example.util.ResultEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.example.entity.User;

@RestController
public class UserController {

	@RequestMapping("/provider/get/user")
	public User getUser(HttpServletRequest request) {
		// 获取当前服务的端口号
		int serverPort = request.getServerPort();
		return new User(1, "HBF " + serverPort, "男");
	}

	@RequestMapping("/provider/get/user/feign")
	public User getUserByFeign() {
		return new User(1, "HBF 使用Feign", "男");
	}

	// 指定当前方法出问题时调用的备份方法（使用fallbackMethod属性指定）
	@HystrixCommand(fallbackMethod = "getUserByHystrixBackup")
	@RequestMapping("/provider/get/user/hystrix")
	public ResultEntity<User> getUserByHystrix(@RequestParam("signal") String signal) throws InterruptedException {

		// 模拟请求出错
		if ("quick-bang".equals(signal)) {
			throw new RuntimeException();
		}

		// 模拟请求出错
		if ("slow-bang".equals(signal)) {
			Thread.sleep(5000);
		}
		return ResultEntity.successWithData(new User(1, "HBF 使用Hystrix", "男"));
	}

	public ResultEntity<User> getUserByHystrixBackup(@RequestParam("signal") String signal) {
		String message = "方法执行出现问题，执行断路 signal=" + signal;
		return ResultEntity.failed(message);
	}
}
