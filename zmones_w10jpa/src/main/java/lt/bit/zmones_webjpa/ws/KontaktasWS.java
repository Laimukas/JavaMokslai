package lt.bit.zmones_webjpa.ws;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import lt.bit.zmones_webjpa.data.Kontaktas;
import lt.bit.zmones_webjpa.data.Zmogus;

import java.util.ArrayList;
import java.util.List;

@Path("zmogus/{zmogusId}/kontaktas")
public class KontaktasWS {
    
    @Context
    private HttpServletRequest request;

    @Context
    private HttpServletResponse response;

    @GET
    @Produces("application/json")
    public List<Kontaktas> list(@PathParam("zmogusId") Integer zmogusId) {
        EntityManager em = (EntityManager) request.getAttribute("em");
        Zmogus z = em.find(Zmogus.class, zmogusId);
        List<Kontaktas> list;
        if (z == null) {
            list = new ArrayList();
        } else {
            list = z.getKontaktai();
        }
        return list;
    }
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Kontaktas getOne(
            @PathParam("zmogusId") Integer zmogusId,
            @PathParam("id") Integer id
    ) {
        EntityManager em = (EntityManager) request.getAttribute("em");
        Kontaktas k = em.find(Kontaktas.class, id);
        if (k != null && k.getZmogus().getId() == zmogusId) {
            return k;
        }
        return null;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Kontaktas add(Kontaktas k,  @PathParam("zmogusId") Integer zmogusId ) {
        if (k == null) {
            throw new NullPointerException("Nera ka issaugoti");
        }
        k.setId(null);
        EntityManager em = (EntityManager) request.getAttribute("em");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Zmogus zmogus= em.find(Zmogus.class, zmogusId);


            k.setZmogus(zmogus);
            System.out.println(k);
            em.persist(k);
            tx.commit();
            return k;
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
    public Kontaktas update(@PathParam("id") Integer id, Kontaktas k) {
        if (k == null) {
            throw new NullPointerException("Nera ka issaugoti");
        }
        EntityManager em = (EntityManager) request.getAttribute("em");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Kontaktas kOrig = em.find(Kontaktas.class, id);
            if (kOrig != null) {
                kOrig.setTipas(k.getTipas());
                kOrig.setReiksme(k.getReiksme());
            }
            tx.commit();
            return kOrig;
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
            Kontaktas k = em.find(Kontaktas.class, id);
            if (k == null) {
                return;
            }
            em.remove(k);
            tx.commit();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
        }
    }
}

