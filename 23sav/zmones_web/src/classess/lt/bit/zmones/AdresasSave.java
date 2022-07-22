package lt.bit.zmones;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        Zmogus z = null;
        String zmogusIds = request.getParameter("zmogusId");
        if (zmogusIds != null) {
            try {
                z = Db.getById(Integer.parseInt(zmogusIds));
            } catch (NumberFormatException ex) {
                // ignore
            }
        }
        String ids = request.getParameter("id");
        Adresas k = null;
        if (ids != null) {
            try {
                k = Db.getAdresasById(Integer.parseInt(ids));
                if (k == null) {
                    if (z == null) {
                        response.sendRedirect("index.jsp");
                    } else {
                        response.sendRedirect("adresaiList.jsp?zmogusId=" + z.getId());
                    }
                    return;
                }
                z = Db.getZmogusByAdresas(k);
            } catch (NumberFormatException ex) {
                if (z == null) {
                    response.sendRedirect("index.jsp");
                } else {
                    response.sendRedirect("adresaiList.jsp?zmogusId=" + z.getId());
                }
                return;
            }
        } else {
            if (z != null) {
                k = new Adresas();
                z.getAdresai().add(k);
            } else {
                response.sendRedirect("index.jsp");
                return;
            }
        }
        k.setAdresas(request.getParameter("adresas"));
        k.setMiestas(request.getParameter("miestas"));
        k.setPastoKodas(request.getParameter("pastoKodas"));
        k.setValstybe(request.getParameter("valstybe"));
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
