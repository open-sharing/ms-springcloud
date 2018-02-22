package com.ms.springcloud.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ms.springcloud.hystrix.UserFeignClientFallback;

/**
 * 声明式调用服务的接口类
 *
 * @author wenzongwei
 *         Date 18/2/22
 */
@FeignClient(name = "producer", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    String sayHello(@PathVariable("name") String name);
}
