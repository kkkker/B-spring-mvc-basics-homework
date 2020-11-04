package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import com.thoughtworks.capacity.gtb.mvc.service.WebApiService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
@Validated
public class WebApiController {

    @Autowired
    WebApiService webApiService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid User user) throws Exception {
        webApiService.register(user);
    }

    @GetMapping("/login")
    public User login(@RequestParam @Length(min = 5, max = 12, message = "密码不合法") String password,
                      @RequestParam @Pattern(regexp = "[A-Za-z_0-9]{3,10}$", message = "用户名不合法") String username) {
        return webApiService.login(password, username);
    }
}
