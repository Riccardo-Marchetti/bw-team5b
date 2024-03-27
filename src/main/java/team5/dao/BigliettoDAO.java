package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import team5.entities.Abbonamento;
import team5.entities.Biglietto;
import team5.exception.NotFoundException;

import java.time.LocalDate;

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
    public Biglietto getById(long bigliettoId){
        Biglietto biglietto = em.find(Biglietto.class, bigliettoId);
        if (biglietto == null) throw new NotFoundException(bigliettoId);
        return biglietto;
    }
public long numeroDiBigliettiEmessiDaUnEmittentePerPeriodo(LocalDate dataInizio, LocalDate dataFine, long emittenteId){
    TypedQuery<Long> query = em.createQuery("SELECT COUNT(b) FROM Biglietto b WHERE b.dataEmissione BETWEEN :dataInizio AND :dataFine AND b.emittente.id = :emittenteId", Long.class);
    query.setParameter("dataInizio", dataInizio);
    query.setParameter("dataFine", dataFine);
    query.setParameter("emittenteId", emittenteId);
    return query.getSingleResult();
}
}
