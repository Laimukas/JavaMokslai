package lt.bit.zmones_webjpa.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import lt.bit.zmones_webjpa.data.Zmogus;

@WebServlet(name = "JsonTest", urlPatterns = {"/jsonTest"})
public class JsonTest extends HttpServlet {

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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityManager em = (EntityManager) request.getAttribute("em");
        String filter = request.getParameter("filter");
        if (filter == null) {
            filter = "";
        }
        filter = "%" + filter + "%";
        Query q = em.createQuery("select z from Zmogus z where z.vardas like :filtras or z.pavarde like :filtras order by z.vardas, z.pavarde");
        q.setParameter("filtras", filter);
        List<Zmogus> list = q.getResultList();
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(out, list);
//            out.println("[");
//            for (int i = 0; i < list.size(); i++) {
//                Zmogus zmogus = list.get(i);
//                out.println("{");
//                out.println("\"id\": " + zmogus.getId()+ ",");
//                out.println("\"vardas\": \"" + zmogus.getVardas() + "\",");
//                out.println("\"pavarde\": \"" + zmogus.getPavarde()+ "\",");
//                if (zmogus.getGimimoData() != null) {
//                    out.println("\"gimimoData\": \"" + sdf.format(zmogus.getGimimoData()) + "\",");
//                } else {
//                    out.println("\"gimimoData\": null,");
//                }
//                out.println("\"alga\": " + zmogus.getAlga() + "");
//                out.println("}");
//                if (i < list.size() - 1) {
//                    out.println(",");
//                }
//            }
//            out.println("]");
            out.flush();
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
