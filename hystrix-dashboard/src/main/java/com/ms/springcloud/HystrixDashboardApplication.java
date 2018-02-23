package com.ms.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 可视化监控服务的主类
 *
 * [关键代码]
 *   1. 依赖spring-cloud-starter-hystrix-dashboard
 *   2. 启动类上额外加上@EnableHystrixDashboard, 如需要注册到服务中心则加上@EnableDiscoveryClient
 *
 * @author jwen
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
public class HystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }
}
