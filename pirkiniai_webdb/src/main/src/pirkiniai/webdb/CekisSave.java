package pirkiniai.webdb;


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

@WebServlet(name = "CekisSave", urlPatterns = {"/saveCekis"})
public class CekisSave extends HttpServlet {

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
        Cekis c;
        if (ids != null) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                c = Db.getCekisById(conn, id);
                if (c == null) {
                    response.sendRedirect("index.jsp");
                    return;
                }
            } catch (NumberFormatException ex) {
                response.sendRedirect("index.jsp");
                return;
            } catch (SQLException ex) {
                System.err.println("Failed to find 'cekis': " + ex.getMessage());
                response.sendRedirect("index.jsp");
                return;
            }

        } else {
            c = new Cekis();
        }
        String data = request.getParameter("data");
        try {
            c.setData(sdf.parse(data));
        } catch (Exception ex) {
            // ignore
        }
        c.setParduotuve(request.getParameter("parduotuve"));
        c.setAprasymas(request.getParameter("aprasymas"));


        try {
            if (ids == null) {
                Db.addCekis(conn, c);
            } else {
                Db.updateCekis(conn, c);
            }
        } catch (SQLException ex) {
            System.err.println("Failed to save 'cekis': " + ex.getMessage());
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
