package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import team5.entities.Utente;

import java.util.List;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }


    public void salvaUtente(Utente utente){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(utente);

        transaction.commit();
        System.out.println("Utente: " + utente + " salvato correttamente");
    }



}
