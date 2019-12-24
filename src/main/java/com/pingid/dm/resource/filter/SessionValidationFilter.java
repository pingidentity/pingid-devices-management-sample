package com.pingid.dm.resource.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.HttpMethod;
import java.io.IOException;

public class SessionValidationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession(false);

        if(session == null || req.getMethod().equals(HttpMethod.GET)) {

            if (req.getHeader("x-requested-with") != null) {
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                res.getWriter().write("Invalid session.");
                res.flushBuffer();
                return;
            }

            res.sendRedirect(req.getContextPath());
        }
        else {
            String referer = req.getHeader("referer");
            if (referer != null && referer.endsWith("/pingid-devices-management-sample/")) {
                session.invalidate();
            }

            // pass the request along the filter chain
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
