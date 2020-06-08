package com.example.ribbonservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ribbon简单demo
 * <p>
 * 每个服务都可能会集群部署，服务之间的调用如何保证负载均衡呢？这也就是ribbon要做的事情
 *
 * ribbon常用配置：
 *
 * ribbon:
 *   ConnectTimeout: 1000 #服务请求连接超时时间（毫秒）
 *   ReadTimeout: 3000 #服务请求处理超时时间（毫秒）
 *   OkToRetryOnAllOperations: true #对超时请求启用重试机制
 *   MaxAutoRetriesNextServer: 1 #切换重试实例的最大个数
 *   MaxAutoRetries: 1 # 切换实例后重试最大次数
 *   NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule #修改负载均衡算法
 *
 * @author suvue
 * @date 2020/6/8
 */
@SpringBootApplication
public class RibbonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonServiceApplication.class, args);
    }

}
