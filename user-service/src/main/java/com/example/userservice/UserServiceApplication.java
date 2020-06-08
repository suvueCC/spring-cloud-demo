package com.example.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 首先我们创建一个user-service，用于给Ribbon提供服务调用。
 *
 * @author suvue
 * @date 2020/6/8
 */
@EnableDiscoveryClient //标识为一个服务客户端
@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
