package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team5.entities.Tessera;

public class TesseraDAO {
    private final EntityManager em;

    public TesseraDAO(EntityManager em) {
        this.em = em;
    }


    public void salvaTessera(Tessera tessera){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(tessera);

        transaction.commit();
        System.out.println("Tessera: " + tessera + " salvata correttamente");
    }
}
