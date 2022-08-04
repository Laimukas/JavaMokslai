package zmoneswebdb;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "LogFilter", urlPatterns = {"/*"})
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("-----------------");
        System.out.println("Request started.... ");
        System.out.println("Request from " + request.getRemoteAddr());
        System.out.println("Request to " + ((HttpServletRequest) request).getRequestURI());
        chain.doFilter(request, response);
        System.out.println("-----------------");
        System.out.println("Request finished.... ");
    }

    @Override
    public void destroy() {
    }
}
