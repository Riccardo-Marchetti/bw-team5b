package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team5.entities.Tratta;

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
}
