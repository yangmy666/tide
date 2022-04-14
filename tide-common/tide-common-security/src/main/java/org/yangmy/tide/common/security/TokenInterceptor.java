package org.yangmy.tide.common.security;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.yangmy.tide.common.result.Result;
import org.yangmy.tide.common.result.Status;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author YangMingYang
 * @since 2022-03-31
 */
@Configuration
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private SecurityConfiguration configuration;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod=(HandlerMethod) handler;
            Method method=handlerMethod.getMethod();
            //获取请求头的token
            String token=request.getHeader(configuration.getTokenHeader());
            //判断当前要访问的接口是否需要权限
            if(method.isAnnotationPresent(PreAuthorize.class)){
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
                if(!SecurityUtils.checkToken(token)){
                    Result result=new Result(Status.unAuthorized,"请先登录",null);
                    String json= JSON.toJSONString(result);
                    response.getWriter().print(json);
                    return false;
                }

                //获取接口注解上所允许的权限
                PreAuthorize preAuthorize = method.getAnnotation(PreAuthorize.class);
                String code= preAuthorize.value();
                //判断用户是否有接口访问权限
                List<String> codeList=TokenUtils.parseUserInfo(token).getApiCodeList();
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
            //将token保存到ThreadLocal
            SecurityUtils.setToken(token);
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
        //tomcat线程池复用所以执行完controller方法后要清空ThreadLocal
        SecurityUtils.setToken(null);
    }
}
