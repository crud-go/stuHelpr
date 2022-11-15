package com.ujs.stupool.interceptor;

import com.ujs.stupool.utils.TokenUtil;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("有人来了");
        String myToken = request.getHeader("Token");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        if (!TokenUtil.isTokenValid(myToken)) {
            response.addHeader("Content-Type", "application/json");
            PrintWriter writer = response.getWriter();
            writer.print("{\"status\":404,\"message\":\"/login\"}");

            return false;
        } else {
            HttpSession s = request.getSession();
            s.setAttribute("userid", TokenUtil.getUserIdFromToken(myToken));
         //   s.setAttribute("username", TokenUtil.getUsernameFromToken(myToken));

            return true;

        }


    }


}
