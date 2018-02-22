package com.ms.springcloud.hystrix;

import org.springframework.stereotype.Component;

import com.ms.springcloud.client.UserFeignClient;

/**
 * UserFeignClient的fallback类
 *
 * @author wenzongwei
 *         Date 18/2/22
 */
@Component
public class UserFeignClientFallback implements UserFeignClient {

    @Override
    public String sayHello(String name) {
        return "[UserFeignClientFallback] hello " +  name;
    }
}
