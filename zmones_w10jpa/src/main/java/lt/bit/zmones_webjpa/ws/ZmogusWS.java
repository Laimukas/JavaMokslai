package lt.bit.zmones_webjpa.ws;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
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
    public Zmogus add (Zmogus z){
        System.out.println("Gavom nauja zmogu: "+ z);
        if(z == null){
            throw new NullPointerException("Nera ka issaugoti");
        }
        z.setId(null);
        EntityManager em = (EntityManager) request.getAttribute("em");
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.persist(z);
            tx.commit();
            return z;
        } finally {
            if (tx.isActive()){
                tx.rollback();
            }
        }
    }
}
