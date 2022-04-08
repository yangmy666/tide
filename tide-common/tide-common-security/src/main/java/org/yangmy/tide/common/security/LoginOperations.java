package org.yangmy.tide.common.security;

import javax.servlet.http.HttpServletRequest;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
public interface LoginOperations {

    /**
     * 在确定登录用户名密码正确之后调用此方法为用户生成有效token
     * @param userInfo
     * @return token
     */
    String login(UserInfo userInfo);

    /**
     * 退出登录
     * @param request
     */
    boolean logout(HttpServletRequest request);

    /**
     * 强制下线
     * @param userId
     */
    boolean forcedOffline(String userId);
}
