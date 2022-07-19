package lt.bit.treciasweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Labas",urlPatterns = {
        "/labas","/hello"
})
public class Labas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Labas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Labas at " + request.getContextPath() + "</h1>");
            out.println("<h1>URI: " + request.getRequestURI() + "</h1>");
            out.println("<h1>Path Info: " + request.getPathInfo() + "</h1>");
            out.println("<h1>Path Translated: " + request.getPathTranslated() + "</h1>");
            out.println("<h1>param1 " + request.getParameter("param1") + "</h1>");
            out.println("<h1>IP " + request.getRemoteAddr() + "</h1>");
            out.println("<h1>IP pavadinimas" + request.getRemoteHost() + "</h1>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }
}
