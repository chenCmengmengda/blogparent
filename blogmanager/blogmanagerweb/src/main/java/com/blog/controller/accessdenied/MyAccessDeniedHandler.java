package com.blog.controller.accessdenied;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAccessDeniedHandler implements AccessDeniedHandler {
    private String accessDeniedUrl;

    public MyAccessDeniedHandler() {
    }

    public MyAccessDeniedHandler(String accessDeniedUrl) {
        this.accessDeniedUrl = accessDeniedUrl;
    }

    @Override
    @ResponseBody
    public void handle(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse,
                       AccessDeniedException e) throws IOException, ServletException {
        if(isAjaxRequest(httpServletRequest)) {
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().println("{\"status\":403,\"msg\":\"/403.html\",\"data\":\"\"}");

            httpServletResponse.getWriter().flush();
        } else if (!httpServletResponse.isCommitted()) {// 非AJAX请求，跳转系统默认的403错误界面，在web.xml中配置
            httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN,
                    e.getMessage());
        }

   //     httpServletResponse.sendError(403);
    }

    /**
     *  判断是否为ajax请求
     */
    private boolean isAjaxRequest(HttpServletRequest request) {
        if (request.getHeader("accept").indexOf("application/json") > -1
                || (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").equals(
                "XMLHttpRequest"))) {
            return true;
        }
        return false;
    }



    public String getAccessDeniedUrl() {
        return accessDeniedUrl;
    }

    public void setAccessDeniedUrl(String accessDeniedUrl) {
        this.accessDeniedUrl = accessDeniedUrl;
    }
}
