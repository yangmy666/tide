package org.yangmy.tide.service.system.service;

import org.yangmy.tide.common.result.Result;
import org.yangmy.tide.service.system.entity.SysUser;

/**
 * @author YangMingYang
 * @since 2022/4/14
 */
public interface ILoginService {

    Result login(SysUser sysUser);

    Result logout();
}
