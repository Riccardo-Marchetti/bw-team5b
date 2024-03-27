package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import team5.entities.Abbonamento;
import team5.entities.Emittente;
import team5.exception.NotFoundException;

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
        System.out.println("abbonamento " + abbonamento.getId() + " di " + abbonamento.getUtente().getCognome() + " " + abbonamento.getUtente().getNome() + " inserito ");

    }

    public Abbonamento getById(long abbonamentoId) {
        Abbonamento abbonamento = em.find(Abbonamento.class, abbonamentoId);
        if (abbonamento == null) throw new NotFoundException("abbonamento non trovato");
        return abbonamento;
    }

    public long numeroDiAbbonamentiEmessiDaUnEmittentePerPeriodo(LocalDate dataInizio, LocalDate dataFine, long emittenteId) {
        Emittente emittente = em.find(Emittente.class, emittenteId);
        if (emittente == null) {
            throw new NotFoundException("Emittente con id: " + emittenteId + " non trovato");
        }
        try {
            TypedQuery<Long> query = em.createQuery("SELECT COUNT(b) FROM Abbonamento b WHERE b.dataEmissione BETWEEN :dataInizio AND :dataFine AND b.emittente.id = :emittenteId", Long.class);
            query.setParameter("dataInizio", dataInizio);
            query.setParameter("dataFine", dataFine);
            query.setParameter("emittenteId", emittenteId);
            return query.getSingleResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public List<Abbonamento> verificaAbbonamento(long tesseraId) {
        LocalDate today = LocalDate.now();
        TypedQuery<Abbonamento> query = em.createQuery(
                "SELECT a FROM Abbonamento a WHERE a.utente.tessera.id = :tesseraId AND :today BETWEEN a.dataEmissione AND a.dataScadenza",
                Abbonamento.class
        );

        query.setParameter("tesseraId", tesseraId);
        query.setParameter("today", today);
        return query.getResultList();
    }

    public void annullaAbbonamento(long abbonamentoId) {
        em.getTransaction().begin();
        Abbonamento abbonamento = em.find(Abbonamento.class, abbonamentoId);
        em.remove(abbonamento);
        em.getTransaction().commit();
        System.out.println("Abbonamento annullato");
    }


}
