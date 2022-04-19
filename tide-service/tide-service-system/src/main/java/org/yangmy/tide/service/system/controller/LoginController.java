package org.yangmy.tide.service.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yangmy.tide.common.result.Result;
import org.yangmy.tide.service.system.entity.SysUser;
import org.yangmy.tide.service.system.entity.valid.LoginGroup;
import org.yangmy.tide.service.system.service.ILoginService;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
@RestController
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @PostMapping("/login")
    public Result login(@Validated(LoginGroup.class) @RequestBody SysUser sysUser){
        String token=loginService.login(sysUser);
        if(token==null){
            return Result.failure("登陆失败","用户名或密码错误");
        }
        return Result.success("登录成功",token);
    }

    @PostMapping("/logout")
    public Result logout(){
        if(loginService.logout()){
            return Result.success("退出登录成功");
        }
        return Result.warning("退出登录失败","可能已退出");
    }

}
