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

@WebServlet(name = "PrekeSave", urlPatterns = {"/savePreke"})
public class PrekeSave extends HttpServlet {

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
        Cekis c = null;
        String cekisIds = request.getParameter("cekisId");
        if (cekisIds != null) {
            try {
                c = Db.getCekisById(conn, Integer.parseInt(cekisIds));
            } catch (NumberFormatException ex) {
                // ignore
            } catch (SQLException ex) {
                System.err.println("Failed to find 'cekis': " + ex.getMessage());
                response.sendRedirect("index.jsp");
                return;
            }
        }
        String ids = request.getParameter("id");
        Preke p = null;
        if (ids != null) {
            try {
                p = Db.getPrekeById(conn, Integer.parseInt(ids));
                if (p == null) {
                    if (c == null) {
                        response.sendRedirect("index.jsp");
                    } else {
                        response.sendRedirect("prekesList.jsp?cekisId=" + c.getId());
                    }
                    return;
                }
                c = Db.getCekisByPreke(conn, p);

            } catch (NumberFormatException ex) {
                if (c == null) {
                    response.sendRedirect("index.jsp");
                } else {
                    response.sendRedirect("prekesList.jsp?cekisId=" + c.getId());
                }
                return;
            } catch (SQLException ex) {
                System.err.println("Failed to find 'preke': " + ex.getMessage());
                response.sendRedirect("index.jsp");
                return;
            }
        } else {
            if (c != null) {
                p = new Preke();
                p.setCekisid(c.getId());
            } else {
                response.sendRedirect("index.jsp");
                return;
            }
        }

        p.setPreke(request.getParameter("preke"));
        String kiekis = request.getParameter("kiekis");
        try {
            p.setKiekis(new BigDecimal(kiekis));
        } catch (Exception ex) {
            // ignore
        }
        String kaina = request.getParameter("kaina");
        try {
            p.setKaina(new BigDecimal(kaina));
        } catch (Exception ex) {
            // ignore
        }
        String tipasid = request.getParameter("tipas_id");
        try {
            p.setTipasid(new Integer(tipasid));
        } catch (Exception ex) {
            // ignore
        }
        try {
            if (ids == null) {
                Db.addPreke(conn, p);
            } else {
                Db.updatePreke(conn, p);
            }
        } catch (SQLException ex) {
            System.err.println("Failed to save 'preke': " + ex.getMessage());
        }
        response.sendRedirect("prekesList.jsp?cekisId=" + c.getId());
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
