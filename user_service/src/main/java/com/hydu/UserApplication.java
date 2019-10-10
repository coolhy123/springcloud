package com.hydu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * Created on 2019/10/10
 *
 * @author heyong
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class UserApplication{
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }
}