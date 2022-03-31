package org.yangmy.tide.service.system.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yangmy.tide.common.result.Result;
import org.yangmy.tide.common.result.Status;
import org.yangmy.tide.service.system.entity.SysUser;
import org.yangmy.tide.service.system.entity.valid.LoginGroup;
import org.yangmy.tide.service.system.entity.valid.RegisterGroup;
import org.yangmy.tide.service.system.service.ISysUserService;
import org.yangmy.tide.service.system.utils.SecurityUtils;

import java.util.List;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
@RestController
public class LoginController {

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/login")
    public Result login(@Validated(LoginGroup.class) SysUser sysUser){
        Wrapper<SysUser> queryWrapper=new QueryWrapper<>(sysUser);
        List<SysUser> list=sysUserService.list(queryWrapper);
        if(list.size()==1){
            Long userId=null;
            for (SysUser user : list) {
                userId=user.getId();
            }
            String token=SecurityUtils.generateToken();
            String key = "accessToken" + ":" + userId;
            stringRedisTemplate.opsForValue().set(key,token);
            return Result.success(token);
        }
        return Result.FAILURE(Status.LOGIN_FAILURE);
    }

    @PostMapping("/logout")
    public Result logout(){
        Long userId=SecurityUtils.getUserInfo().getId();
        if(userId!=null){
            stringRedisTemplate.delete("accessToken" + ":"+ userId);
        }
        return Result.success();
    }

    @PostMapping("/register")
    public Result register(@Validated(RegisterGroup.class) SysUser sysUser){
        boolean res=sysUserService.save(sysUser);
        if(res){
            return Result.success();
        }
        return Result.FAILURE(Status.INTERNAL_ERROR);
    }
}
