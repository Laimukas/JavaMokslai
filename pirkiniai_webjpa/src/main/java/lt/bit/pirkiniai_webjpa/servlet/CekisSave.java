package lt.bit.pirkiniai_webjpa.servlet;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lt.bit.pirkiniai_webjpa.data.Cekis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

@WebServlet(name = "CekisSave", urlPatterns = {"/saveCekis"})
public class CekisSave extends HttpServlet {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

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
        request.setCharacterEncoding("UTF-8");
        EntityManager em = (EntityManager) request.getAttribute("em");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            String ids = request.getParameter("id");
            Cekis c;
            if (ids != null) {
                try {
                    int id = Integer.parseInt(request.getParameter("id"));
                    c = em.find(Cekis.class, id);
                    if (c == null) {
                        response.sendRedirect("index.jsp");
                        return;
                    }
                } catch (NumberFormatException ex) {
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


            if (ids == null) {
                em.persist(c);
            }
            tx.commit();
            response.sendRedirect("index.jsp");
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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
