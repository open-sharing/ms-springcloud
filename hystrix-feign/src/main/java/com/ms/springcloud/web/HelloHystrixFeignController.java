package com.ms.springcloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ms.springcloud.client.UserFeignClient;
import com.ms.springcloud.client.UserFeignClient2;

/**
 * Hello World Feign
 *
 * @author wenzongwei
 *         Date 18/2/22
 */
@RestController
public class HelloHystrixFeignController {

    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private UserFeignClient2 userFeignClient2;

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return userFeignClient.sayHello(name);
    }

    @GetMapping("/hello2/{name}")
    public String sayHello2(@PathVariable String name) {
        return userFeignClient2.sayHello(name);
    }
}
