package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import team5.entities.Tessera;
import team5.entities.Utente;

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
        TypedQuery<Tessera> query = em.createNamedQuery("findTesseraById", Tessera.class);
        query.setParameter("tesseraId", id);
        return query.getSingleResult();
    }

    public void aggiornaTesseraScaduta(long id){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

       Tessera tessera = findTesseraById(id);
       tessera.setDataScadenza(LocalDate.now().plusYears(1));

        em.merge(tessera);
        transaction.commit();
        System.out.println("Tessera: " + tessera + " aggiornata correttamente");
    }
}
