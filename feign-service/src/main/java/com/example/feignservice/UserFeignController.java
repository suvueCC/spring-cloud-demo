package com.example.feignservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * feign的负载均衡功能演示：
 * 启动 eurekaServer、 userServiceApplication、
 * userServiceReplicaApplication、FeignServiceApplication
 * 多次调用 http://localhost:8701/user/1 发现两个userService的控制台交替打印信息
 * <p>
 * feign的服务熔断降级功能演示：
 * --编写一个实现类（UserFallbackServiceImpl），实现@feignClient注解标注的接口（UserService），
 * 并实现其方法，方法内容为服务熔断降级后的执行过程
 * --@feignClient的fallback属性设置为该实现类
 * 测试：关闭两个userServer，访问FeignService的接口，发现请求被熔断
 *
 * @author suvue
 * @date 2020/6/9
 */
@RestController
@RequestMapping("/user")
public class UserFeignController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id) {
        return userService.getById(id);
    }
}
