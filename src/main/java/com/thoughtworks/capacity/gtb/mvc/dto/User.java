package com.thoughtworks.capacity.gtb.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private int id;

    @NotEmpty(message = "用户名不为空")
    @Pattern(regexp = "[A-Za-z_0-9]{3,10}$", message = "用户名不合法")
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Length(min = 5, max = 12, message = "密码不合法")
    private String password;
    private String email;
}
