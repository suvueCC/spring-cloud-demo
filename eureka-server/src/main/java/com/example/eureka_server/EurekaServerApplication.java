package com.example.eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p>为什么会有微服务？
 * 单体项目每次迭代变更时，修改的部分可能会影响到其他的功能。对单体项目进行垂直拆分，每个功能就是一个单独的服务。
 * 彼此之间独立部署，互不影响。
 * </p>
 *
 * <p>什么是springCloud?
 * 是多个springboot项目集成的综合项目，可以这么说，springboot是实现springCloud的根基。
 * 它提供了一套服务发现注册、配置中心、智能路由、消息总线、负载均衡、断路器、数据监控的分布式解决方案。
 *
 * 注册中心主要用于服务治理
 * --每个服务启动的时候都要向eureka注册自己的地址和端口信息
 * --eureka维护着服务名称和地址的映射关系
 * --每个服务都会定时拉取服务注册列表，并报告自己的运行状态
 * --这样当需要调用别的服务时，从注册中心中查找就行
 * --eureka维护了这么一套服务注册与发现机制
 *
 * 由于服务调用都依赖于注册中心，eureka一旦宕机，所有的服务调用都会出现问题，因此有必要配置eureka集群。
 *
 * @author suvue
 * @date 2020/6/8
 */
//启动服务注册中心提供给其他应用进行对话
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}
