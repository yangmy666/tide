package org.yangmy.tide.service.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yangmy.tide.common.result.Result;
import org.yangmy.tide.service.system.entity.dto.RegisterDto;
import org.yangmy.tide.service.system.service.IRegisterService;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
@RestController
@Validated
public class RegisterController {

    @Autowired
    private IRegisterService registerService;

    @PostMapping("/sendMailCode")
    public Result sendMailCode(
            @NotBlank(message ="邮箱不能为空")
            @Email(message = "邮箱格式不正确")
            @RequestParam("mail") String mail){
        return registerService.sendMailCode(mail);
    }

    @PostMapping("/register")
    public Result register(@Valid @RequestBody RegisterDto registerDto){
        return registerService.register(registerDto);
    }

}
