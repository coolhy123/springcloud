package com.hydu.client.impl;

import com.hydu.client.UserClient;
import org.springframework.stereotype.Component;

/**
 * Created on 2019/10/10
 *
 * @author heyong
 */
@Component
public class UserClientImpl implements UserClient {
    @Override
    public String getAll(int id) {
        return "id为："+id+"的用户请求时服务器开小差了";
    }
}