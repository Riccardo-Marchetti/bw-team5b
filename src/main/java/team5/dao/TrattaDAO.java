package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import team5.entities.Tratta;
import team5.exception.NotFoundException;

import java.util.List;

public class TrattaDAO {
    private final EntityManager em;

    public TrattaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Tratta tratta) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(tratta);
        tx.commit();
        System.out.println("Tratta " + tratta.getPartenza()+ " " + tratta.getCapolinea() + " salvato con successo");
    }

    public Tratta findById(int id) {
        Tratta tratta = em.find(Tratta.class, id);
        if (tratta == null) throw new NotFoundException(id);
        return tratta;
    }

    public void findByIdAndDelete(Tratta tratta) {
        Tratta found = this.findById(tratta.getId());
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(found);
        tx.commit();
        System.out.println("Tratta eliminata con successo");
    }

    public List<Tratta> findAll() {
        TypedQuery<Tratta> query = em.createQuery("SELECT t FROM Tratta t", Tratta.class);
        return query.getResultList();
    }
}
