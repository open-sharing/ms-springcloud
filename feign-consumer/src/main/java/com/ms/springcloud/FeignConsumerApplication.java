package com.ms.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 声明式RESTful API调用服务主类
 *
 * [关键代码]
 *   1. 依赖spring-cloud-starter-feign
 *   2. 在启动类上额外加上@EnableFeignClients
 *   3. 声明式调用服务的接口类@FeignClient
 *
 * @author jwen
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class FeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class, args);
    }
}
