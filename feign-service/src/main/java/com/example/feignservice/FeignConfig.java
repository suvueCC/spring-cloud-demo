package com.example.feignservice;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * feign的配置类（目前暂时配置日志 打印的层级）
 *
 * @author suvue
 * @date 2020/6/9
 */
@Configuration
public class FeignConfig {

    /**
     * 通过配置开启更为详细的日志
     */
    @Bean
    Logger.Level level(){
        return Logger.Level.FULL;
    }
}
