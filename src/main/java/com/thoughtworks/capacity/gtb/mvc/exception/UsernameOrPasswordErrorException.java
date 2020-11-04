package com.thoughtworks.capacity.gtb.mvc.exception;

public class UsernameOrPasswordErrorException extends Exception {

    @Override
    public String getMessage() {
        return "用户名或密码错误";
    }
}
