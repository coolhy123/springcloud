package com.hydu.client;

import com.hydu.client.impl.UserClientImpl;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 2019/10/10
 *
 * @author heyong
 */

@FeignClient(value = "user-service",configuration = FeignClientsConfiguration.class,fallback = UserClientImpl.class)
@Service
public interface UserClient {

    @GetMapping("/user/{id}")
    public String getAll(@PathVariable("id")int id);
}
