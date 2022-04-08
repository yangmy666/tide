package org.yangmy.tide.service.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.yangmy.tide.common.result.Result;
import org.yangmy.tide.service.system.entity.SysUser;
import org.yangmy.tide.service.system.entity.dto.RegisterDto;
import org.yangmy.tide.service.system.service.ISysUserService;
import org.yangmy.tide.service.system.service.MailOperations;
import org.yangmy.tide.service.system.utils.StringUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
@RestController
@RequestMapping("/register")
@Validated
public class RegisterController {

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ThreadPoolExecutor executor;
    @Autowired
    private MailOperations mailOperations;

    @PostMapping("/sendCode")
    public Result sendCode(@NotBlank @RequestParam("mail") String mail){
        //生成4位验证码
        String code= StringUtils.generateRandomStr(4);
        String key="register:mail:"+mail;
        stringRedisTemplate.opsForValue().set(key,code,60, TimeUnit.SECONDS);
        executor.execute(()-> mailOperations.sendMessage(mail,"潮汐-邮箱注册验证码",code));
        return Result.ok(60);
    }

    @PostMapping("/")
    public Result register(@RequestBody @Valid RegisterDto registerDto){
        String key="register:mail:"+registerDto.getMail();
        String code=stringRedisTemplate.opsForValue().get(key);
        if(registerDto.getCode().equals(code)){
            SysUser sysUser=new SysUser();
            sysUser.setUsername(registerDto.getUsername());
            sysUser.setPassword(registerDto.getPassword());
            sysUser.setMail(registerDto.getMail());
            if(sysUserService.save(sysUser)){
                return Result.success("注册成功");
            }
            return Result.failure("注册失败");
        }
        return Result.failure("验证码错误");
    }
}
