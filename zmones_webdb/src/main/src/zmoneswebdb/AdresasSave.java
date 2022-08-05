package zmoneswebdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "AdresasSave", urlPatterns = {"/saveAdresas"})
public class AdresasSave extends HttpServlet {

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
        Zmogus z = null;
        String zmogusIds = request.getParameter("zmogusId");
        if (zmogusIds != null) {
            try {
                z = Db.getZmogusById(conn, Integer.parseInt(zmogusIds));
            } catch (NumberFormatException ex) {
                // ignore
            } catch (SQLException ex) {
                System.err.println("Failed to find 'zmogus': " + ex.getMessage());
                response.sendRedirect("index.jsp");
                return;
            }
        }
        String ids = request.getParameter("id");
        Adresas a = null;
        if (ids != null) {
            try {
                a = Db.getAdresasById(conn, Integer.parseInt(ids));
                if (a == null) {
                    if (z == null) {
                        response.sendRedirect("index.jsp");
                    } else {
                        response.sendRedirect("adresaiList.jsp?zmogusId=" + z.getId());
                    }
                    return;
                }
                z = Db.getZmogusByAdresas(conn, a);
            } catch (NumberFormatException ex) {
                if (z == null) {
                    response.sendRedirect("index.jsp");
                } else {
                    response.sendRedirect("adresaiList.jsp?zmogusId=" + z.getId());
                }
                return;
            } catch (SQLException ex) {
                System.err.println("Failed to find 'adresas': " + ex.getMessage());
                response.sendRedirect("index.jsp");
                return;
            }
        } else {
            if (z != null) {
                a = new Adresas();
                a.setZmogusId(z.getId());
            } else {
                response.sendRedirect("index.jsp");
                return;
            }
        }
        a.setAdresas(request.getParameter("adresas"));
        a.setMiestas(request.getParameter("miestas"));
        a.setPastoKodas(request.getParameter("pastoKodas"));
        try {
            if (ids == null) {
                Db.addAdresas(conn, a);
            } else {
                Db.updateAdresas(conn, a);
            }
        } catch (SQLException ex) {
            System.err.println("Failed to save 'adresas': " + ex.getMessage());
        }
        response.sendRedirect("adresaiList.jsp?zmogusId=" + z.getId());
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
