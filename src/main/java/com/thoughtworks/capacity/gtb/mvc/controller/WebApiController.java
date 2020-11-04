package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import com.thoughtworks.capacity.gtb.mvc.service.WebApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebApiController {

    @Autowired
    WebApiService webApiService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(User user) {
        webApiService.register(user);
    }
}
