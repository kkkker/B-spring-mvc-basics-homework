package com.thoughtworks.capacity.gtb.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private int id;

    @NotEmpty(message = "用户名不为空")
    private String username;

    @NotEmpty(message = "密码不能为空")
    private String password;
    private String email;
}
