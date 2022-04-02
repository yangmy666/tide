package org.yangmy.tide.service.system.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yangmy.tide.common.result.Result;
import org.yangmy.tide.common.result.Status;
import org.yangmy.tide.common.security.LoginTemplate;
import org.yangmy.tide.common.security.UserInfo;
import org.yangmy.tide.service.system.entity.SysUser;
import org.yangmy.tide.service.system.entity.valid.LoginGroup;
import org.yangmy.tide.service.system.entity.valid.RegisterGroup;
import org.yangmy.tide.service.system.mapper.SysPermissionMapper;
import org.yangmy.tide.service.system.service.ISysUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private LoginTemplate loginTemplate;

    @PostMapping("/login")
    public Result login(@RequestBody @Validated(LoginGroup.class) SysUser sysUser){
        Wrapper<SysUser> queryWrapper=new QueryWrapper<>(sysUser);
        List<SysUser> list=sysUserService.list(queryWrapper);
        if(list.size()==1){
            SysUser user=list.get(0);
            UserInfo userInfo=new UserInfo();
            userInfo.setId(user.getId());
            userInfo.setUsername(user.getUsername());
            //查询用户拥有的权限
            List<String> codeList=sysPermissionMapper.selectPermissionCodeByUserId(user.getId());
            userInfo.setCodeList(codeList);
            String token=loginTemplate.login(userInfo);
            Map<String,Object> map=new HashMap<>();
            map.put("userInfo",userInfo);
            map.put("token",token);
            return Result.success(map);
        }
        return Result.FAILURE(Status.LOGIN_FAILURE);
    }

    @PostMapping("/logout")
    public Result logout(HttpServletRequest request){
        loginTemplate.logout(request);
        return Result.success();
    }

    @PostMapping("/register")
    public Result register(@RequestBody @Validated(RegisterGroup.class) SysUser sysUser){
        boolean res=sysUserService.save(sysUser);
        if(res){
            return Result.success();
        }
        return Result.FAILURE(Status.ERROR);
    }
}
