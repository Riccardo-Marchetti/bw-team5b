package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import team5.entities.Tessera;
import team5.entities.Utente;
import team5.exception.NotFoundException;

import java.security.spec.ECField;
import java.time.LocalDate;

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



    public Tessera findTesseraById(long id){
        try {
            TypedQuery<Tessera> query = em.createNamedQuery("findTesseraById", Tessera.class);
            query.setParameter("tesseraId", id);
            return query.getSingleResult();
        }catch (NotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void aggiornaTesseraScaduta(long id){
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            Tessera tessera = findTesseraById(id);
            tessera.setDataScadenza(LocalDate.now().plusYears(1));

            em.merge(tessera);
            transaction.commit();
            System.out.println("Tessera: " + tessera + " aggiornata correttamente");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void eliminaTesseraScadutaById(long id){
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            Query query = em.createNamedQuery("deleteTesseraScaduta");
            query.setParameter("currentDate", LocalDate.now());
            query.setParameter("tesseraId", id);
            System.out.println("Tessera " + id + " eliminata");
            query.executeUpdate();

            transaction.commit();
        }catch (NotFoundException e){
            System.out.println(e.getMessage());
        }

    }
}
