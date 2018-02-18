package com.ms.springcloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ms.springcloud.client.UserFeignClient;

/**
 * Hello World Feign
 *
 * @author wenzongwei
 *         Date 18/2/18
 */
@RestController
public class HelloFeignController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return userFeignClient.sayHello(name);
    }
}
