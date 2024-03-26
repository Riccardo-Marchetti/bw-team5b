package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team5.entities.Abbonamento;

public class AbbonamentoDAO {
    private final EntityManager em;

    public AbbonamentoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Abbonamento abbonamento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(abbonamento);

        transaction.commit();
        System.out.println("abbonamento " + abbonamento.getId() + "di" + abbonamento.getUtente().getCognome() + "inserito");

    }

    
}
