package lt.bit.zmones_webjpa.servlet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lt.bit.zmones_webjpa.data.Kontaktas;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "KontaktasDelete", urlPatterns = {"/deleteKontaktas"})
public class KontaktasDelete extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager em = (EntityManager) request.getAttribute("em");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Integer zmogusId = null;
            String ids = request.getParameter("id");
            try {
                int id = Integer.parseInt(ids);
                Kontaktas k = em.find(Kontaktas.class, id);
                zmogusId = k.getZmogus().getId();
                if (k != null) {
                    em.remove(k);
                    tx.commit();
                }

            } catch (Exception ex) {
                System.out.println("Failed to delete: " + ex.getMessage());
            } finally {
                if (zmogusId == null) {
                    response.sendRedirect("index.jsp");
                } else {
                    response.sendRedirect("kontaktaiList.jsp?zmogusId=" + zmogusId);
                }

            }
        }finally {
            if (tx.isActive()) {
                tx.rollback();
            }
        }
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
        protected void doGet (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo () {
            return "Short description";
        }// </editor-fold>
}