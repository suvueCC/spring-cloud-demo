package com.example.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 实现feign的客户端
 *
 * @author suvue
 * @date 2020/6/9
 */
//value为user-service表示这是对user-service服务的接口调用客户端。
//fallback为服务降级时的错误处理类
@FeignClient(value = "user-service", fallback = UserFallbackServiceImpl.class)
public interface UserService {

    @GetMapping("/user/{id}")
    Result getById(@PathVariable Long id);
}
