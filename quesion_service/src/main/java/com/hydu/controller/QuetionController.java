package com.hydu.controller;

import com.hydu.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2019/10/10
 *
 * @author heyong
 */
@RestController
@RequestMapping("/question")
public class QuetionController {

    @Autowired
    private UserClient userClient;

    @RequestMapping("/queryAll/{id}")
    public String queryAll(@PathVariable int id){
        return userClient.getAll(id);

    }
}