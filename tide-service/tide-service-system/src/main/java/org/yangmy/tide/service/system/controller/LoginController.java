package org.yangmy.tide.service.system.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yangmy.tide.common.result.Result;
import org.yangmy.tide.common.security.SecurityUtils;
import org.yangmy.tide.common.security.UserInfo;
import org.yangmy.tide.service.system.entity.SysUser;
import org.yangmy.tide.service.system.entity.valid.LoginGroup;
import org.yangmy.tide.service.system.mapper.SysPermissionMapper;
import org.yangmy.tide.service.system.service.ISysUserService;

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
    private SysPermissionMapper sysPermissionMapper;

    @PostMapping("/login")
    public Result login(@Validated(LoginGroup.class) @RequestBody SysUser sysUser){
        Wrapper<SysUser> queryWrapper=new QueryWrapper<>(sysUser);
        //根据用户名和密码查找用户
        List<SysUser> list=sysUserService.list(queryWrapper);
        if(list.size()==1){
            SysUser user=list.get(0);
            //创建userInfo
            UserInfo userInfo=new UserInfo();
            userInfo.setId(user.getId());
            userInfo.setUsername(user.getUsername());
            //查询用户拥有的权限
            List<String> codeList=sysPermissionMapper.selectPermissionCodeByUserId(user.getId());
            userInfo.setCodeList(codeList);
            //登录，生成token
            String token= SecurityUtils.login(userInfo);
            return Result.success("登录成功",token);
        }
        return Result.failure("登陆失败","用户名或密码错误");
    }

    @PostMapping("/logout")
    public Result logout(){
        if(SecurityUtils.logout()){
            return Result.success("退出登录成功");
        }
        return Result.warning("退出登录失败","可能已退出");
    }

}
