package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WebApiService {

    private List<User> usersDataBase;

    public WebApiService() {
        usersDataBase = new ArrayList<>();
    }

    public void register(User user) {
        usersDataBase.add(user);
    }
}
