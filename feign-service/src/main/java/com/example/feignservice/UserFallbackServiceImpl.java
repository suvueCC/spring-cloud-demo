package com.example.feignservice;

import org.springframework.stereotype.Component;

/**
 * 服务降级实现类
 *
 * @author suvue
 * @date 2020/6/9
 */
@Component
public class UserFallbackServiceImpl implements UserService {
    @Override
    public Result getById(Long id) {
        return new Result("服务调用失败，服务被降级！", 500);
    }
}
