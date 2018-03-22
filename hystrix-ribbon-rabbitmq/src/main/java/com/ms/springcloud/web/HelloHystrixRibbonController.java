package com.ms.springcloud.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.EurekaInstanceConfig;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Hello World
 *
 * @author wenzongwei
 *         Date 17/22/3
 */
@RestController
public class HelloHystrixRibbonController {

    protected Logger logger = LoggerFactory.getLogger(HelloHystrixRibbonController.class);

    @Autowired
    private EurekaInstanceConfig eurekaInstanceConfig;
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "sayHelloFallback")
    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        String serviceUrl = "http://PRODUCER/hello/" + name;
        String responseBody = restTemplate.getForEntity(serviceUrl, String.class).getBody();
        logger.info("/hello/{}, instanceId:{}, host:{}", name, eurekaInstanceConfig.getInstanceId(), eurekaInstanceConfig.getHostName(false));
        return responseBody;
    }

    public String sayHelloFallback(String name) {
        return "[HelloHystrixRibbonController:sayHelloFallback] hello " + name;
    }
}
