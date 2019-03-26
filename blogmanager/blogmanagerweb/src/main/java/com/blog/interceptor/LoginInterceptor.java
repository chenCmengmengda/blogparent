package com.blog.interceptor;


import com.blog.common.util.CookieUtils;
import com.blog.pojo.TbUser;
import com.blog.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 陈_C on 2018/7/19.
 */
public class LoginInterceptor implements HandlerInterceptor {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        //在Handler执行之前处理
        //判断用户是否登录
        //从cookie中取token
        HttpSession session=request.getSession();
        String username=(String)session.getAttribute("username");
 //       String username = CookieUtils.getCookieValue(request, "username");
        //根据token换取用户信息，调用sso系统的接口。
//        TbUser user = userService.getUserByToken(token);

        System.out.println(request.getSession());
        //取不到用户信息
        if (null == username) {
            //跳转到登录页面，把用户请求的url作为参数传递给登录页面。
            response.sendRedirect("/page/login");
            //返回false
            return false;
        }
        //取到用户信息，放行
        //把用户信息保存到Request

    //    request.setAttribute("username",username);

        //返回值决定handler是否执行。true:执行，false:不执行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        //在Handler之后返回modelAndView之前
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        //在返回modenAndView之后
    }
}
