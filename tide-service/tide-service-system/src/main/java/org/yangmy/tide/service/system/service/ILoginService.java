package org.yangmy.tide.service.system.service;

import org.yangmy.tide.service.system.entity.SysUser;

/**
 * @author YangMingYang
 * @since 2022/4/14
 */
public interface ILoginService {

    String login(SysUser sysUser);

    boolean logout();
}
