package com.ms.springcloud.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.EurekaInstanceConfig;

/**
 * Hello World
 *
 * @author wenzongwei
 *         Date 17/12/3
 */
@RestController
public class WorldController {

    protected Logger logger = LoggerFactory.getLogger(WorldController.class);

    @Autowired
    private EurekaInstanceConfig eurekaInstanceConfig;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/hello_world", method = RequestMethod.GET)
    public String helloWorld() {
        String serviceUrl = "http://PRODUCER/hello";
        String responseBody = restTemplate.getForEntity(serviceUrl, String.class).getBody();
        logger.info("/world, instanceId:{}, host:{}", eurekaInstanceConfig.getInstanceId(), eurekaInstanceConfig.getHostName(false));
        return responseBody + " World!";
    }

}
