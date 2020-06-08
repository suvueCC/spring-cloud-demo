package com.example.hystrixservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * htstrix熔断器demo
 * <p>简介
 * Hystrix具备服务降级、服务熔断、线程隔离、请求缓存、请求合并及服务监控等强大功能。
 * 调用链上某一个服务发生故障，它会将请求进行熔断，返回一个错误响应，而不是无休止地等待。
 * 有利于提高服务的稳定性
 * <p>
 * 使用上其实很简单，在方法消费端，加 @HystrixCommand(fallbackMethod = "")
 * fallbackMethod是调用失败时执行的方法
 * 它还可以设置缓存、忽略某些异常等，这里不讨论了，有需要再学
 * </p>
 *
 * 常用配置：
 *
 * hystrix:
 *   command: #用于控制HystrixCommand的行为
 *     default:
 *       execution:
 *         isolation:
 *           strategy: THREAD #控制HystrixCommand的隔离策略，THREAD->线程池隔离策略(默认)，SEMAPHORE->信号量隔离策略
 *           thread:
 *             timeoutInMilliseconds: 1000 #配置HystrixCommand执行的超时时间，执行超过该时间会进行服务降级处理
 *             interruptOnTimeout: true #配置HystrixCommand执行超时的时候是否要中断
 *             interruptOnCancel: true #配置HystrixCommand执行被取消的时候是否要中断
 *           timeout:
 *             enabled: true #配置HystrixCommand的执行是否启用超时时间
 *           semaphore:
 *             maxConcurrentRequests: 10 #当使用信号量隔离策略时，用来控制并发量的大小，超过该并发量的请求会被拒绝
 *       fallback:
 *         enabled: true #用于控制是否启用服务降级
 *       circuitBreaker: #用于控制HystrixCircuitBreaker的行为
 *         enabled: true #用于控制断路器是否跟踪健康状况以及熔断请求
 *         requestVolumeThreshold: 20 #超过该请求数的请求会被拒绝
 *         forceOpen: false #强制打开断路器，拒绝所有请求
 *         forceClosed: false #强制关闭断路器，接收所有请求
 *       requestCache:
 *         enabled: true #用于控制是否开启请求缓存
 *   collapser: #用于控制HystrixCollapser的执行行为
 *     default:
 *       maxRequestsInBatch: 100 #控制一次合并请求合并的最大请求数
 *       timerDelayinMilliseconds: 10 #控制多少毫秒内的请求会被合并成一个
 *       requestCache:
 *         enabled: true #控制合并请求是否开启缓存
 *   threadpool: #用于控制HystrixCommand执行所在线程池的行为
 *     default:
 *       coreSize: 10 #线程池的核心线程数
 *       maximumSize: 10 #线程池的最大线程数，超过该线程数的请求会被拒绝
 *       maxQueueSize: -1 #用于设置线程池的最大队列大小，-1采用SynchronousQueue，其他正数采用LinkedBlockingQueue
 *       queueSizeRejectionThreshold: 5 #用于设置线程池队列的拒绝阀值，由于LinkedBlockingQueue不能动态改版大小，使用时需要用该参数来控制线程数
 *
 *
 *
 * @author suvue
 * @date 2020/6/8
 */
@EnableCircuitBreaker //开启hystrix的断路器功能
@EnableDiscoveryClient //标识它为一个服务客户端
@SpringBootApplication
public class HystrixServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixServiceApplication.class, args);
    }

}
