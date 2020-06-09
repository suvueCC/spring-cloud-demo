package com.example.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * 配置中心demo
 *
 * 服务端从git / github获取数据  客户端 从服务端拿数据
 *
 * @author suvue
 * @date 2020/6/9
 */
@SpringBootApplication
@EnableDiscoveryClient //配置为eureka服务发现的对象
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

}
