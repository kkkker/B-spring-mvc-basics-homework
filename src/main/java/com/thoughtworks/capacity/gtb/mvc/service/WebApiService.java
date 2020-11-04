package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UsernameExistException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WebApiService {

    private final List<User> usersDataBase;

    public WebApiService() {
        usersDataBase = new ArrayList<>();
    }

    public void register(User user) throws Exception {
        if (usersDataBase.stream().anyMatch(userData -> userData.getUsername().equals(user.getUsername()))) {
            throw new UsernameExistException();
        }
        usersDataBase.add(user);
    }
}
