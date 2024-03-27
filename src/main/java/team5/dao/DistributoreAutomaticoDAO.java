package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team5.entities.DistributoreAutomatico;
import team5.entities.Rivenditore;

public class DistributoreAutomaticoDAO {
    private final EntityManager em;

    public DistributoreAutomaticoDAO(EntityManager em) {
        this.em = em;
    }

    public void salvaDistributore(DistributoreAutomatico distributoreAutomatico){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(distributoreAutomatico);

        transaction.commit();
        System.out.println("DistributoreAutomatico: " + distributoreAutomatico + " salvato correttamente");
    }

}
