package com.ms.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * RabbitMQ容错服务主类
 *
 * [关键代码]
 *   1. 依赖spring-cloud-starter-hystrix,
 *         spring-cloud-starter-ribbon,
 *         spring-cloud-netflix-hystrix-amqp (spring-cloud-netflix-hystrix-stream, spring-cloud-starter-stream-rabbit)
 *
 *   2. 启动类上额外加上@EnableCircuitBreaker 或@EnableHystrix
 *   3. 在请求上增加熔断保护配置 @HystrixCommand
 *   4. 配置文件增加rabbitmq认证信息
 *
 * @author jwen
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
public class HystrixRibbonRabbitMQApplication {

    /**
     * [关键代码]负载均衡设置
     *
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main( String[] args ){
        SpringApplication.run(HystrixRibbonRabbitMQApplication.class, args);
    }
}
