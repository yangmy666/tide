package org.yangmy.tide.service.system.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
@Data
public class RegisterDto {

    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
    @NotBlank(message = "邮箱账号不能为空")
    private String mail;
    @NotBlank(message = "邮箱验证码不能为空")
    private String code;
}
