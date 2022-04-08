package org.yangmy.tide.service.system.entity.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
@Data
public class RegisterDto {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String mail;
    @NotBlank
    private String code;
}
