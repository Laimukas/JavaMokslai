package lt.bit.zmones_webjpa.ws;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;

import java.util.List;

import lt.bit.zmones_webjpa.data.Zmogus;

@Path("zmogus")
public class ZmogusWS {

    @Context
    private HttpServletRequest request;

    @Context
    private HttpServletResponse response;

    @GET
    @Produces("application/json")
    public List<Zmogus> list() {
        EntityManager em = (EntityManager) request.getAttribute("em");
        Query q = em.createQuery("select z from Zmogus z order by z.vardas, z.pavarde");
        List<Zmogus> list = q.getResultList();
        return list;
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Zmogus getOne(@PathParam("id") Integer id) {
        if (id == null) {
            return null;
        }
        EntityManager em = (EntityManager) request.getAttribute("em");
        Zmogus z = em.find(Zmogus.class, id);
        return z;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Zmogus add(Zmogus z) {
        if (z == null) {
            throw new NullPointerException("Nera ka issaugoti");
        }
        z.setId(null);
        EntityManager em = (EntityManager) request.getAttribute("em");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(z);
            tx.commit();
            return z;
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
    public Zmogus update(@PathParam("id") Integer id, Zmogus z) {
        if (z == null) {
            throw new NullPointerException("Nera ka issaugoti");
        }
        EntityManager em = (EntityManager) request.getAttribute("em");
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Zmogus zOrig = em.find(Zmogus.class, id);
            if (zOrig != null) {
                zOrig.setVardas(z.getVardas());
                zOrig.setPavarde(z.getPavarde());
                zOrig.setGimimoData(z.getGimimoData());
                zOrig.setAlga(z.getAlga());
            }
            tx.commit();
            return zOrig;
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
            Zmogus z = em.find(Zmogus.class, id);
            if (z == null) {
                return;
            }
            em.remove(z);
            tx.commit();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
        }
    }
}
