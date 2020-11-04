package com.thoughtworks.capacity.gtb.mvc.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class UsernameExistException extends Exception {
    private final String message = "用户名已存在";

    @Override
    public String getMessage() {
        return message;
    }
}
