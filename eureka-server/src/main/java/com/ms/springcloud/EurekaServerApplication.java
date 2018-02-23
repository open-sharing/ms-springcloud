package com.ms.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册主类
 *
 * [关键代码]
 *   1. 依赖spring-cloud-starter-eureka-server
 *   2. 启动类上额外加上@EnableEurekaServer
 *   3. 高可用的话java -jar eureka-server-1.0-SNAPSHOT.jar --spring.profiles.active=host1
 *
 * @author jwen
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaServerApplication.class).web(true).run(args);
    }

}
