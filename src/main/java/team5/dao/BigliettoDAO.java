package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team5.entities.Biglietto;

public class BigliettoDAO {
    private final EntityManager em;

    public BigliettoDAO(EntityManager em) {
        this.em = em;
    }

    public void salvaBiglietto(Biglietto biglietto){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(biglietto);

        transaction.commit();
        System.out.println("Biglietto: " + biglietto + " salvato correttamente");
    }
}
