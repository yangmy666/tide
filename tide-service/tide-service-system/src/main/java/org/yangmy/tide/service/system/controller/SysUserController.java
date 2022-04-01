package org.yangmy.tide.service.system.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yangmy.tide.common.security.PreAuth;
import org.yangmy.tide.service.system.entity.SysUser;
import org.yangmy.tide.service.system.service.ISysUserService;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author YangMingYang
 * @since 2022-03-31
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @PreAuth("system:user:search")
    @GetMapping("/search")
    public List<SysUser> search(SysUser sysUser){
        Wrapper<SysUser> wrapper=new QueryWrapper<SysUser>()
                .eq(sysUser.getId()!=null,"id",sysUser.getId())
                .like(sysUser.getUsername()!=null,"username",sysUser.getUsername());
        return sysUserService.list(wrapper);
    }

}
