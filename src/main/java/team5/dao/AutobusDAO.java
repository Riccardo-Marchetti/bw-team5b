package team5.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import team5.entities.Autobus;

import java.util.List;

public class AutobusDAO {

    private final EntityManager em;

    public AutobusDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Autobus autobus) {
        em.getTransaction().begin();
        em.persist(autobus);
        em.getTransaction().commit();
        System.out.println("Autobus salvato con successo");
    }

    public Autobus findById(long id) {
        return em.find(Autobus.class, id);
    }

    public void findByIdAndDelete(Autobus autobus) {
        em.getTransaction().begin();
        em.remove(autobus);
        em.getTransaction().commit();
        System.out.println("Autobus eliminato con successo");
    }

    public List<Autobus> findAll() {
        TypedQuery<Autobus> query = em.createQuery("SELECT a FROM Autobus a", Autobus.class);
        return query.getResultList();
    }
}
