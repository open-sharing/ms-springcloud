package com.ms.springcloud.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ms.springcloud.client.UserFeignClient2;

import feign.hystrix.FallbackFactory;

/**
 * UserFeignClient2的FallbackFactory
 *
 * @author wenzongwei
 *         Date 18/2/22
 */
@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient2> {
    protected Logger logger = LoggerFactory.getLogger(UserFeignClientFallbackFactory.class);

    @Override
    public UserFeignClient2 create(Throwable throwable) {
        return new UserFeignClient2() {

            @Override
            public String sayHello(String name) {
                logger.warn("sayHello has been fallbacked due to: ", throwable);
                return "[UserFeignClientFallbackFactory] hello " + name;
            }
        };
    }
}
