package com.example.hystrixservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @Override
    @HystrixCommand(fallbackMethod = "fallbackMethod1", ignoreExceptions = IOException.class)
    public Result testFallback(Long id) {
        return restTemplate.getForObject(userServiceUrl + "/user/{id}", Result.class, id);
    }

    /**
     * 声明的参数需要包含控制层方法的参数
     *
     * @author suvue
     * @date 2020/6/8
     */
    public Result fallbackMethod1(@PathVariable Long id) {
        return new Result("服务调用失败", 500);
    }
}
