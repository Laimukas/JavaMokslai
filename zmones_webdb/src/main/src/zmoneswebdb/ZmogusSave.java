package zmoneswebdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

@WebServlet(name = "ZmogusSave", urlPatterns = {"/saveZmogus"})
public class ZmogusSave extends HttpServlet {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Connection conn = (Connection) request.getAttribute("conn");
        String ids = request.getParameter("id");
        Zmogus z;
        if (ids != null) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                z = Db.getZmogusById(conn, id);
                if (z == null) {
                    response.sendRedirect("index.jsp");
                    return;
                }
            } catch (NumberFormatException ex) {
                response.sendRedirect("index.jsp");
                return;
            } catch (SQLException ex) {
                System.err.println("Failed to find 'zmogus': " + ex.getMessage());
                response.sendRedirect("index.jsp");
                return;
            }

        } else {
            z = new Zmogus();
        }
        z.setVardas(request.getParameter("vardas"));
        z.setPavarde(request.getParameter("pavarde"));
        String alga = request.getParameter("alga");
        try {
            z.setAlga(new BigDecimal(alga));
        } catch (Exception ex) {
            // ignore
        }
        String gimimoData = request.getParameter("gimimoData");
        try {
            z.setGimimoData(sdf.parse(gimimoData));
        } catch (Exception ex) {
            // ignore
        }
        try {
            if (ids == null) {
                Db.addZmogus(conn, z);
            } else {
                Db.updateZmogus(conn, z);
            }
        } catch (SQLException ex) {
            System.err.println("Failed to save 'zmogus': " + ex.getMessage());
        }
        response.sendRedirect("index.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
