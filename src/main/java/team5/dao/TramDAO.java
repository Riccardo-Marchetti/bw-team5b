package team5.dao;



import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import team5.entities.Tram;

import java.util.List;

public class TramDAO {

    private final EntityManager em;

    public TramDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Tram tram) {
        em.getTransaction().begin();
        em.persist(tram);
        em.getTransaction().commit();
        System.out.println("Tram salvato con successo");
    }

    public Tram findById(int id) {
        return em.find(Tram.class, id);
    }

    public void findByIdAndDelete(Tram tram) {
        em.getTransaction().begin();
        em.remove(tram);
        em.getTransaction().commit();
        System.out.println("Tram eliminato con successo");
    }

    public List<Tram> findAll() {
        TypedQuery<Tram> query = em.createQuery("SELECT t FROM Tram t", Tram.class);
        return query.getResultList();
    }
}

