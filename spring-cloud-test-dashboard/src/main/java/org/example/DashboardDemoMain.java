package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author Acos、
 * @date 2022-07-18 17:43
 * GitHub: https://github.com/bumblebee-code-gh
 * Description:
 */

// 启用仪表盘监控功能
@EnableHystrixDashboard
@SpringBootApplication
public class DashboardDemoMain {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DashboardDemoMain.class, args);
    }
}
