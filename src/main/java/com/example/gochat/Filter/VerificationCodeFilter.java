package com.example.gochat.Filter;

import com.example.gochat.Exception.jsonResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class VerificationCodeFilter extends GenericFilter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //如果是登录请求则拦截
        if ("POST".equals(request.getMethod()) && request.getServletPath().endsWith("/register")) {
            //用户输入的验证码
            String code = request.getParameter("code");
            //session中保存的验证码
            String verify_code = (String) request.getSession().getAttribute("mail_verify_code");

            response.setContentType("application/json;charset=utf-8");
            try {
                //验证是否相同
                if (!code.equals(verify_code)) {
                    //输出json
                    PrintWriter writer = response.getWriter();
                    writer.write(new ObjectMapper().writeValueAsString(jsonResult.error(400, "验证码错误!")));
                    writer.close();
                    return;
                } else {
                    filterChain.doFilter(request, response);
                }
            } catch (NullPointerException e) {
                PrintWriter writer = response.getWriter();
                writer.write(new ObjectMapper().writeValueAsString(jsonResult.error(400, "请求异常，请重新请求！")));
                writer.close();
            }
        } else {
            filterChain.doFilter(request,response);
        }
    }
}