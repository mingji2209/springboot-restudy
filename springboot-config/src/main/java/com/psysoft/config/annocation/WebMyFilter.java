package com.psysoft.config.annocation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


public class WebMyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
