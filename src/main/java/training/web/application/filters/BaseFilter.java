package training.web.application.filters;

import training.web.application.dao.DBException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The Base Filter superclass that implements methods {@link Filter#init(FilterConfig)}
 * and {@link Filter#destroy()} and casts arguments
 * of method {@link Filter#doFilter(ServletRequest, ServletResponse, FilterChain)} to
 * {@link HttpServletRequest} and {@link HttpServletResponse}.
 * @author Ihor Savchenko
 */
public abstract class BaseFilter implements Filter {
    public void init(FilterConfig filterConfig) {
         /*NOP*/
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        req.setCharacterEncoding("utf-8");
        doFilter(req, resp, filterChain);
    }

    public abstract void doFilter(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, DBException;

    public void destroy() {
         /*NOP*/
    }
}
