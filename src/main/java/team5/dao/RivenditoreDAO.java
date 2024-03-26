package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team5.entities.Rivenditore;


public class RivenditoreDAO {
    private final EntityManager em;

    public RivenditoreDAO(EntityManager em) {
        this.em = em;
    }

    public void salvaRivenditore(Rivenditore rivenditore){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(rivenditore);

        transaction.commit();
        System.out.println("Rivenditore: " + rivenditore + " salvato correttamente");
    }
}
