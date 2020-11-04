package com.thoughtworks.capacity.gtb.mvc.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UsernameExistException extends Exception {

    @Override
    public String getMessage() {
        return "用户名已存在";
    }
}
