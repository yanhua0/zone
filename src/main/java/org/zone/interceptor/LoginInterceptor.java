package org.zone.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.zone.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        System.out.println("拦截链接："+request.getServletPath());
        HttpSession session = request.getSession();
        User user= (User) session.getAttribute("user");
        String url=request.getRequestURI();
        if(url.indexOf("/check")>=0)
        {
            return true;
        }
        if(url.indexOf("/login")>=0)
        {
            return true;
        }
        if(user!=null){
            return true;
        }else{
            request.getRequestDispatcher("/WEB-INF/views/html/login.jsp").forward(request,response);
            return false;
        }

    }
    //返回modelAndView之前执行

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("postHandle");
    }
    //执行Handler完成执行此方法

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("afterCompletion");
    }
}