package org.yangmy.tide.common.security;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.yangmy.tide.common.result.Result;
import org.yangmy.tide.common.result.Status;

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
                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                if(token==null||token.equals("")){
                    //token为空
                    Result result=new Result(Status.unAuthorized,"请先登录",null);
                    String json= JSON.toJSONString(result);
                    response.getWriter().print(json);
                    return false;
                }
                //验证token是否有效
                try {
                    Long userId=TokenUtils.parseUserInfo(token).getId();
                    String sessionId=strRedisTemplate.opsForValue().get(LoginTemplate.SESSION_KEY_PREFIX +userId);
                    if(!Objects.equals(sessionId, TokenUtils.parseSessionId(token))){
                        Result result=new Result(Status.unAuthorized,"请先登录",null);
                        String json= JSON.toJSONString(result);
                        response.getWriter().print(json);
                        return false;
                    }
                }catch (Exception e){
                    Result result=new Result(Status.unAuthorized,"请先登录",null);
                    String json= JSON.toJSONString(result);
                    response.getWriter().print(json);
                    return false;
                }

                //获取接口注解上所允许的权限
                PreAuth preAuth=method.getAnnotation(PreAuth.class);
                String code=preAuth.value();
                //判断是否有权访问
                List<String> codeList=TokenUtils.parseUserInfo(token).getCodeList();
                boolean permissionDenied=true;
                for (String code1 : codeList) {
                    if (code1.equals(code)) {
                        permissionDenied = false;
                        break;
                    }
                }
                if(permissionDenied){
                    Result result=new Result(Status.permissionDenied,"权限不足",null);
                    String json= JSON.toJSONString(result);
                    response.getWriter().print(json);
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
