package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import team5.entities.Abbonamento;
import team5.entities.Emittente;

import java.time.LocalDate;
import java.util.List;

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
        System.out.println("abbonamento " + abbonamento.getId() + " di " + abbonamento.getUtente().getCognome() + " inserito ");

    }

    public long numeroDiAbbonamentiEmessiDaUnEmittentePerPeriodo(LocalDate dataInizio, LocalDate dataFine, long emittenteId){
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(b) FROM Abbonamento b WHERE b.dataEmissione BETWEEN :dataInizio AND :dataFine AND b.emittente.id = :emittenteId", Long.class);
        query.setParameter("dataInizio", dataInizio);
        query.setParameter("dataFine", dataFine);
        query.setParameter("emittenteId", emittenteId);
        return query.getSingleResult();
    }

    public Abbonamento verificaAbbonamento(long numeroTessera){
      LocalDate today =  LocalDate.now();
        TypedQuery<Abbonamento> query = em.createQuery("SELECT a FROM Abbonamento a WHERE a.utente.numeroTessera = :numeroTessera AND :today BETWEEN a.dataEmissione AND a.dataScadenza ", Abbonamento.class);
    query.setParameter("today", today);
    query.setParameter("numeroTessera", numeroTessera);
        return query.getSingleResult();
    }
}
