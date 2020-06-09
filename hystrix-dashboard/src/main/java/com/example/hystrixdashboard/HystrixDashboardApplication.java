package com.example.hystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 是一种查看Hystrix实例运行情况的仪表盘组件
 *
 * @author suvue
 * @date 2020/6/9
 */
@EnableDiscoveryClient //标识为eureka服务发现的对象
@EnableHystrixDashboard //启动监控功能
@SpringBootApplication
public class HystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class, args);
    }

}
