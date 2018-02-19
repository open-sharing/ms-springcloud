package com.ms.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 *  [关键代码]
 *    1. spring-cloud-starter-ribbon
 *    2. 启动类中初始化RestTemplate增加 @LoadBalanced
 *
 * @author jwen
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Application {

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

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
