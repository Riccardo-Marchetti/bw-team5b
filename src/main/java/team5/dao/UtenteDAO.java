package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import team5.entities.Tessera;
import team5.entities.Utente;
import team5.exception.NotFoundException;

import java.time.LocalDate;
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

    public Utente findUtenteById(long id){
        try {
            TypedQuery<Utente> query = em.createNamedQuery("findUtenteById", Utente.class);
            query.setParameter("utenteId", id);
            return query.getSingleResult();
        }catch (NotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void eliminaUtenteById(long id){
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            Query query = em.createNamedQuery("deleteUtente");
            query.setParameter("utenteId", id);
            System.out.println("Utente " + id + " eliminato");
            query.executeUpdate();

            transaction.commit();
        }catch (NotFoundException e){
            System.out.println(e.getMessage());
        }

    }

}
