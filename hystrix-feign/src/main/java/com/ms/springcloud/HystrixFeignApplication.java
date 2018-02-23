package com.ms.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 声明式RESTful API调用服务主类(hystrix版)
 *
 * [关键代码]
 *   1. 依赖spring-cloud-starter-hystrix, 依赖spring-cloud-starter-feign
 *   2. 启动类上额外加上@EnableCircuitBreaker(或@EnableHystrix)
 *   3. UserFeignClientFallback上@Component
 *   4. 声明式调用服务的接口类 @FeignClient(name = "producer", fallback = UserFeignClientFallback.class)
 *   5. [坑]配置文件:feign.hystrix.enabled=true
 *      参照:http://blog.csdn.net/qq_20079921/article/details/77990935?locationNum=7&fps=1
 *
 * @author jwen
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class HystrixFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixFeignApplication.class, args);
    }
}
