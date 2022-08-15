package lt.bit.zmones_webjpa.ws;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import java.util.List;
import lt.bit.zmones_webjpa.data.Zmogus;

@Path("zmogus")
public class ZmogusWS {
    
    @Context
    private HttpServletRequest request;
    
    @GET
    @Produces("application/json")
    public List<Zmogus> list() {
        EntityManager em = (EntityManager) request.getAttribute("em");
        Query q = em.createQuery("select z from Zmogus z order by z.vardas, z.pavarde");
        List<Zmogus> list = q.getResultList();
        return list;
//        List<Zmogus> l = new ArrayList();
//        Zmogus z;
//        z = new Zmogus(1, "Jonas", "Jonaitis", null, BigDecimal.TEN);
//        l.add(z);
//        z = new Zmogus(2, "Petras", "Petraitis", new Date(), new BigDecimal("651.48"));
//        l.add(z);
//        return l;
    }
}
