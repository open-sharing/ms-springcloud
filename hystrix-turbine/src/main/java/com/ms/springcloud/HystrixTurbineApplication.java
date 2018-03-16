package com.ms.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 集群监控服务主类
 *
 * [关键代码]
 *   1. 依赖spring-cloud-starter-turbine
 *   2. 启动类上额外加上@EnableTurbine
 *   3. 配置文件:turbine.app-config
 *
 * @author jwen
 */
@SpringBootApplication
@EnableTurbine
public class HystrixTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineApplication.class, args);
    }
}
