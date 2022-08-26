package lt.bit.zmones_webjpa.ws;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import lt.bit.zmones_webjpa.data.Adresas;
import lt.bit.zmones_webjpa.data.Zmogus;

import java.util.ArrayList;
import java.util.List;

@Path("zmogus/{zmogusId}/adresas")
public class AdresasWS {
    
    @Context
    private HttpServletRequest request;

    @Context
    private HttpServletResponse response;

    @GET
    @Produces("application/json")
    public List<Adresas> list(@PathParam("zmogusId") Integer zmogusId) {
        EntityManager em = (EntityManager) request.getAttribute("em");
        Zmogus z = em.find(Zmogus.class, zmogusId);
        List<Adresas> list;
        if (z == null) {
            list = new ArrayList();
        } else {
            list = z.getAdresai();
        }
        return list;
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Adresas getOne(
            @PathParam("zmogusId") Integer zmogusId,
            @PathParam("id") Integer id
    ) {
        EntityManager em = (EntityManager) request.getAttribute("em");
        Adresas a = em.find(Adresas.class, id);
        if (a != null && a.getZmogus().getId() == zmogusId) {
            return a;
        }
        return null;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Adresas add(Adresas a) {
        if (a == null) {
            throw new NullPointerException("Nera ka issaugoti");
        }
        a.setId(null);
        EntityManager em = (EntityManager) request.getAttribute("em");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(a);
            tx.commit();
            return a;
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
        }
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Adresas update(@PathParam("id") Integer id, Adresas a) {
        if (a == null) {
            throw new NullPointerException("Nera ka issaugoti");
        }
        EntityManager em = (EntityManager) request.getAttribute("em");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Adresas aOrig = em.find(Adresas.class, id);
            if (aOrig != null) {
                aOrig.setAdresas(a.getAdresas());
                aOrig.setMiestas(a.getMiestas());
                aOrig.setPastoKodas(a.getPastoKodas());
            }
            tx.commit();
            return aOrig;
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
        }
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id) {
        response.setStatus(204);
        if (id == null) {
            return;
        }
        EntityManager em = (EntityManager) request.getAttribute("em");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Adresas a = em.find(Adresas.class, id);
            if (a == null) {
                return;
            }
            em.remove(a);
            tx.commit();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
        }
    }

}
