package com.example.zuulproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * zuul可作为微服务中各个服务的入口，是所以微服务的门面。所有客户端的访问都通过它来进行路由和过滤
 * 它实现了请求路由、负载均衡、校验过滤、服务容错、服务聚合等功能
 *
 * Zuul的两大核心：过滤和路由
 *
 * <p>
 * 通过在yml文件中 配置zuul的routers属性，可以配置客户端访问的路由（zuul只是统一管理了所有的客户端请求，
 * 但是它不影响客户端直接对各个微服务的请求）
 *
 * 负载均衡功能：多次访问 http://localhost:8801/user-service/user/1，我们发现控制台是交替打印的
 * 配置访问前缀：zuul的prefix属性
 * 查看详细路由信息：配置actuator依赖和yml 访问 http://localhost:8801/actuator/routes/details
 *
 * 过滤器：
 * 类型：
 * 1.pre请求路由前置过滤
 * 2.routing请求路由到zuul上的时候，执行过滤
 * 3.post请求路由后置过滤
 * 4.error请求在其他阶段发生错误时，执行过滤
 *
 *
 * 常用配置：
 * zuul:
 *   routes: #给服务配置路由
 *     user-service:
 *       path: /userService/**
 *     feign-service:
 *       path: /feignService/**
 *   ignored-services: user-service,feign-service #关闭默认路由配置
 *   prefix: /proxy #给网关路由添加前缀
 *   sensitive-headers: Cookie,Set-Cookie,Authorization #配置过滤敏感的请求头信息，设置为空就不会过滤
 *   add-host-header: true #设置为true重定向是会添加host请求头
 *   retryable: true # 关闭重试机制
 *   PreLogFilter:
 *     pre:
 *       disable: false #控制是否启用过滤器
 *
 * @author suvue
 * @date 2020/6/9
 */
@EnableDiscoveryClient //标识为eureka服务发现的对象
@EnableZuulProxy //启用zuul的api网关功能
@SpringBootApplication
public class ZuulProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulProxyApplication.class, args);
    }

}
