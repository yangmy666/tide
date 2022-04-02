package org.yangmy.tide.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
@Configuration
public class HeaderInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate strRedisTemplate;
    @Autowired
    private TideSecurityConfiguration configuration;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod=(HandlerMethod) handler;
            Method method=handlerMethod.getMethod();
            //获取请求头的token
            String token=request.getHeader(configuration.getTokenHeader());
            //判断当前要访问的接口是否需要权限
            if(method.isAnnotationPresent(PreAuth.class)){
                //验证token是否有效
                if(token==null||token.equals("")){
                    //token为空
                    response.getWriter().write("未授权");
                    return false;
                }
                try {
                    Long userId=TokenUtils.parseUserInfo(token).getId();
                    String sessionId=strRedisTemplate.opsForValue().get("session" + ":" +userId);
                    if(!Objects.equals(sessionId, TokenUtils.parseSessionId(token))){
                        response.getWriter().write("未授权");
                        return false;
                    }
                }catch (Exception e){
                    response.getWriter().write("未授权");
                    return false;
                }

                //获取接口注解上所允许的权限
                PreAuth preAuth=method.getAnnotation(PreAuth.class);
                String code=preAuth.value();
                //判断是否有权访问
                List<String> codeList=TokenUtils.parseUserInfo(token).getCodeList();
                boolean notPermission=true;
                for (String code1 : codeList) {
                    if (code1.equals(code)) {
                        notPermission = false;
                        break;
                    }
                }
                if(notPermission){
                    response.getWriter().write("权限不足");
                    return false;
                }
            }
            try {
                //通行后获取token中的用户信息
                UserInfo userInfo= TokenUtils.parseUserInfo(token);
                //将token中的用户信息保存到ThreadLocal
                SecurityUtils.setUserInfo(userInfo);
            }catch (Exception ignored){}
        }
        return true;
    }
}
