package com.example.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 首先我们创建一个user-service，用于给Ribbon提供服务调用。
 * feign时ribbon和hystrix的集大成者，拥有了ribbon的负载均衡功能、hystrix的熔断降级功能
 * 并且是声明式注解使用，即插即拔。很方便
 *
 *
 * 常用配置：
 *
 * feign:
 *   hystrix:
 *     enabled: true #在Feign中开启Hystrix
 *   compression:
 *     request:
 *       enabled: false #是否对请求进行GZIP压缩
 *       mime-types: text/xml,application/xml,application/json #指定压缩的请求数据类型
 *       min-request-size: 2048 #超过该大小的请求会被压缩
 *     response:
 *       enabled: false #是否对响应进行GZIP压缩
 * logging:
 *   level: #修改日志级别
 *     com.jourwon.springcloud.service: debug
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
