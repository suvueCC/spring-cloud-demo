package com.example.hystrixservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserHystrixController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @HystrixCommand(fallbackMethod = "fallbackMethod1")
    @GetMapping("/testFallback/{id}")
    public Result testFallback(@PathVariable Long id) {
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
