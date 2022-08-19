package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author Acos、
 * @date 2022-07-19 16:03
 * GitHub: https://github.com/bumblebee-code-gh
 * Description:
 */

// 启用Zuul的网关代理功能
@EnableZuulProxy
@SpringBootApplication
public class ZuulDemoMain {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ZuulDemoMain.class, args);
    }

}
