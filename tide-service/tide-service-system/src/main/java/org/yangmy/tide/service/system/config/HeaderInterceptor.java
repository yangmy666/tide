package org.yangmy.tide.service.system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.yangmy.tide.common.result.Result;
import org.yangmy.tide.common.result.Status;
import org.yangmy.tide.service.system.entity.SysUser;
import org.yangmy.tide.service.system.utils.PreAuth;
import org.yangmy.tide.service.system.utils.SecurityUtils;
import org.yangmy.tide.service.system.utils.TokenUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
@Configuration
public class HeaderInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod=(HandlerMethod) handler;
            Method method=handlerMethod.getMethod();
            Class<?> clazz=method.getDeclaringClass();
            //获取请求头的token
            String token=request.getHeader("accessToken");
            //判断当前要访问的接口是否需要权限
            if(clazz.isAnnotationPresent(PreAuth.class)){
                if(token.equals("")||token==null){
                    //没有令牌，未授权
                    response.getWriter().print(Result.FAILURE(Status.UNAUTHORIZED));
                    return false;
                }
                String tokenId;
                try {
                    tokenId=TokenUtils.parseId(token);
                }catch (Exception e){
                    //令牌解析错误，未授权
                    response.getWriter().print(Result.FAILURE(Status.UNAUTHORIZED));
                    return false;
                }
                //获取接口注解上所允许的权限
                PreAuth preAuth=clazz.getAnnotation(PreAuth.class);
                String[] codes=preAuth.code();
                //判断是否有权访问

            }
            //通行后获取token中的用户信息
            if(token!=null&&!token.equals("")){
                try {
                    SysUser sysUser= TokenUtils.parseUserInfo(token);
                    //将token中的用户信息保存到ThreadLocal
                    SecurityUtils.setUserInfo(sysUser);
                }catch (Exception ignored){}
            }
        }
        return true;
    }
}
