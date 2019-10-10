package com.hydu.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2019/10/10
 * @author heyong
 */
@RestController
@RequestMapping("/user")

public class UserController {

    @HystrixCommand(
        //熔断器开启时调用的方法，该方法的入参和返回值必须与请求的方法一致
        fallbackMethod = "getUserFallBack",
        commandProperties = {
            //请求超时时间
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1000"),
            //该参数为请求出问题的次数，如果超过这个值就开启熔断器，每次默认隔5秒熔断器测试请求，如果请求还是有问题，就开启熔断器，如果请求
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2")

        }
    )
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String getUser(@PathVariable int id)  {
        if(id%2==0){
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        }

        return "用户id："+id+"查询成功！！";

    }

    public String getUserFallBack( int id) {

        return "阿哦，服务器开小差了";

    }


}