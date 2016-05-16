package ru.bk.leontev.fedor.filters;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({"/index.html"})
public class AuthFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Incert in filter");
        //reques
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        //if ((((HttpServletRequest) request).getRequestURI()).startsWith("/login/")) {

            if (session == null) {
                //chain.doFilter(request, response);
                System.out.println("Session is null");
                String loginURI = ((HttpServletRequest) request).getContextPath() + "/login/login.html";
                ((HttpServletResponse) response).sendRedirect(loginURI);
            } else {
                chain.doFilter(request, response);
                //System.out.println("Session is not null");
                //((HttpServletResponse) response).sendRedirect("/index.html");
            }
        //}
        System.out.println("Output from filter");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy filter");
    }
}