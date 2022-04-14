package org.yangmy.tide.service.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yangmy.tide.common.result.Result;
import org.yangmy.tide.common.security.SecurityUtils;
import org.yangmy.tide.common.security.UserInfo;
import org.yangmy.tide.service.system.entity.SysUser;
import org.yangmy.tide.service.system.mapper.SysPermissionMapper;
import org.yangmy.tide.service.system.mapper.SysUserMapper;
import org.yangmy.tide.service.system.service.ILoginService;

import java.util.List;

/**
 * @author YangMingYang
 * @since 2022/4/14
 */
@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public Result login(SysUser sysUser) {
        Wrapper<SysUser> queryWrapper=new QueryWrapper<>(sysUser);
        //根据用户名和密码查找用户
        List<SysUser> list=sysUserMapper.selectList(queryWrapper);
        if(list.size()==1){
            SysUser user=list.get(0);
            //创建userInfo
            UserInfo userInfo=new UserInfo();
            userInfo.setId(user.getId());
            userInfo.setUsername(user.getUsername());
            //查询用户拥有的前端权限
            List<String> pageCodeList=sysPermissionMapper.selectPermissionCodeByUserId(user.getId(),0);
            userInfo.setPageCodeList(pageCodeList);
            //查询用户拥有的后端权限
            List<String> apiCodeList=sysPermissionMapper.selectPermissionCodeByUserId(user.getId(),1);
            userInfo.setApiCodeList(apiCodeList);
            //登录，生成token
            String token= SecurityUtils.login(userInfo);
            return Result.success("登录成功",token);
        }
        return Result.failure("登陆失败","用户名或密码错误");
    }

    @Override
    public Result logout() {
        if(SecurityUtils.logout()){
            return Result.success("退出登录成功");
        }
        return Result.warning("退出登录失败","可能已退出");
    }
}
