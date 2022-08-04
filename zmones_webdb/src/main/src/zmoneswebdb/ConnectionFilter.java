package zmoneswebdb;

import java.io.IOException;
import java.rmi.ServerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter(filterName = "ConnectionFilter", urlPatterns = {"*.jsp", "/deleteZmogus","/saveZmogus","/saveKontaktas","/deleteKontaktas"})
public class ConnectionFilter implements Filter {
    private static final String URL = "jdbc:mysql://localhost:3306/adresu_knyga";
    private static final String USER = "prog";
    private static final String PASS = "programa1programa1";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASS);
        ) {
            request.setAttribute("conn", conn);
            chain.doFilter(request, response);
        } catch (SQLException ex) {
            throw new ServerException("Failed to connect to DB", ex);
        }
    }
    @Override
    public void destroy() {
    }
}