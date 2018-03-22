package com.ms.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * 通过abbitmq实现集群监控的服务主类
 *
 * [关键代码]
 *   1. 依赖spring-cloud-starter-turbine-amqp (spring-cloud-starter-turbine-stream,spring-cloud-starter-stream-rabbit)
 *   2. 启动类上额外加上@EnableTurbineStream
 *   3. 配置文件增加rabbitmq认证信息
 *   4. 为了解决Spring boot 1.x下 TurbineStream服务无法注册的问题, 还需配置一个management.port和eureka.instance.non-secure-port
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbineStream
public class HystrixTurbineRabbitMQApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineRabbitMQApplication.class, args);
    }
}
