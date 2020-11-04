package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.dto.User;
import com.thoughtworks.capacity.gtb.mvc.exception.UsernameExistException;
import com.thoughtworks.capacity.gtb.mvc.exception.UsernameOrPasswordErrorException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        user.setId(usersDataBase.size() + 1);
        usersDataBase.add(user);
    }

    public User login(String password, String username) throws Exception {
        Optional<User> optionalUser = usersDataBase.stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst();
        return optionalUser.orElseThrow(UsernameOrPasswordErrorException::new);
    }
}
