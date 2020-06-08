package com.example.ribbonservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * 这里演示 调用user-service的接口实现
 *
 * @author suvue
 * @date 2020/6/8
 */
@RestController
@RequestMapping("/user")
public class UserRibbonController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @RequestMapping("/{id}")
    public Result getUser(@PathVariable Long id) {
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", Result.class, id);
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody User user) {
        return restTemplate.postForObject(userServiceUrl + "/user/insert", user, Result.class);
    }
}
