package org.yangmy.tide.service.system.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yangmy.tide.common.result.Result;
import org.yangmy.tide.common.security.PreAuthorize;
import org.yangmy.tide.service.system.entity.SysUser;
import org.yangmy.tide.service.system.service.ISysUserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author YangMingYang
 * @since 2022-03-31
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ISysUserService sysUserService;

    @PreAuthorize("system:user:search")
    @GetMapping("/list")
    public Result list(SysUser sysUser){
        Wrapper<SysUser> wrapper=new QueryWrapper<SysUser>()
                .eq(sysUser.getId()!=null,"id",sysUser.getId())
                .like(sysUser.getUsername()!=null,"username",sysUser.getUsername());
        return Result.ok(sysUserService.list(wrapper));
    }

}
