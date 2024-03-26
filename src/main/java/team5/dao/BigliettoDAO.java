package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import team5.entities.Biglietto;

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
//public long numeroDiBigliettiEmessiDaUnEmittentePerPeriodo(LocalDate dataInizio, LocalDate dataFine, long emittenteId){
//    TypedQuery<Long> query = em.createQuery("SELECT COUNT(b) FROM Biglietto b WHERE b.dataEmissione BETWEEN :dataInizio AND :dataFine AND b.rivenditore.id = :emittenteId", Long.class);
//    query.setParameter("dataInizio", dataInizio);
//    query.setParameter("dataFine", dataFine);
//    query.setParameter("rivenditoreId", emittenteId);
//    return query.getSingleResult();
//}
//public int numeroDiBigliettiEmessiDaUnEmittentePerPeriodo(LocalDate dataInizio, LocalDate dataFine, long rivenditoreId){
//    TypedQuery<Long> query = em.createQuery("SELECT COUNT(b) FROM Biglietto b WHERE b.dataEmissione BETWEEN :dataInizio AND :dataFine AND b.rivenditore.id = :rivenditore.id", Long.class);
//    query.setParameter("dataInizio", dataInizio);
//    query.setParameter("dataFine", dataFine);
//    query.setParameter("emittenteId", rivenditoreId);
//    return query.getSingleResult().intValue();
//}
//public long numeroDiBigliettiEmessiDaUnEmittentePerPeriodo(LocalDate dataInizio, LocalDate dataFine, long rivenditoreId){
//    TypedQuery<Long> query = em.createQuery("SELECT COUNT(b) FROM Biglietto b WHERE b.dataEmissione BETWEEN :dataInizio AND :dataFine AND b.rivenditore.id = :rivenditoreId", Long.class);
//    query.setParameter("dataInizio", dataInizio);
//    query.setParameter("dataFine", dataFine);
//    query.setParameter("rivenditoreId", rivenditoreId);
//    return query.getSingleResult();
//}
}
