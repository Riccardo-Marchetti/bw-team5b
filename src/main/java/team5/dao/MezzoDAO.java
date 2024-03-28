package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import team5.entities.Manutenzione;
import team5.entities.Mezzo;
import team5.entities.Tratta;
import team5.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public class MezzoDAO {

    private final EntityManager em;

    public MezzoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Mezzo mezzo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(mezzo);
        transaction.commit();
        System.out.println("Mezzo salvato con successo");
    }

    public Mezzo findById(int id) {
        Mezzo mezzo = em.find(Mezzo.class, id);
        if (mezzo == null) throw new NotFoundException(id);
        System.out.println("Mezzo trovato con successo!");
        return mezzo;

    }

    public void findByIdAndDelete(Mezzo mezzo) {
        Mezzo found = this.findById(mezzo.getId());
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Mezzo eliminato con successo");
    }

    public List<Mezzo> findMezziInServizio() {  // query da cambiare  "SELECT DISTINCT i.mezzo FROM InServizio i"
        TypedQuery<Mezzo> query = em.createQuery("SELECT m FROM Mezzo m WHERE m.inServizio = true", Mezzo.class);
        return query.getResultList();
    }

    public List<Mezzo> findMezziInServizioByTratta(Tratta tratta) {
        TypedQuery<Mezzo> query = em.createQuery("SELECT m FROM Mezzo m WHERE m.inServizio = true AND m.tratta = :tratta", Mezzo.class);
        query.setParameter("tratta", tratta);
        return query.getResultList();
    }

    public Long countPercorsiByMezzoAndTratta(Mezzo mezzo, Tratta tratta) {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(p) FROM Percorso p WHERE p.mezzo = :mezzo AND p.tratta = :tratta", Long.class);
        query.setParameter("mezzo", mezzo);
        query.setParameter("tratta", tratta);
        return query.getSingleResult();
    }

    public Long calculateTempoEffettivoPercorrenza(Mezzo mezzo, Tratta tratta) {
        TypedQuery<Long> query = em.createQuery("SELECT SUM(p.tempoEffettivo) FROM Percorso p WHERE p.mezzo = :mezzo AND p.tratta = :tratta", Long.class);
        query.setParameter("mezzo", mezzo);
        query.setParameter("tratta", tratta);
        return query.getSingleResult();
    }

    public Long countPercorsiByMezzoAndTratta(int numeroMatricola, String partenza, String capolinea) {
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(p) FROM Tratta p WHERE p.numeroMatricola = :numeroMatricola AND (p.partenza = :partenza AND p.capolinea = :capolinea)", Long.class);
        query.setParameter("numeroMatricola", numeroMatricola);
        query.setParameter("partenza", partenza);
        query.setParameter("capolinea", capolinea);
        return query.getSingleResult();
    }

    public List<Manutenzione> periodiDiManutenzioneDelMezzo (LocalDate dataInizioPeriodo, LocalDate dataFinePeriodo, int mezzoId){
        TypedQuery<Manutenzione> query = em.createQuery("SELECT m FROM Manutenzione m WHERE m.data_inizio <= :dataFinePeriodo AND m.data_fine >= :dataInizioPeriodo AND m.mezzo.id =:mezzoId ", Manutenzione.class);
        query.setParameter("dataInizioPeriodo",dataInizioPeriodo);
        query.setParameter("dataFinePeriodo",dataFinePeriodo);
        query.setParameter("mezzoId",mezzoId);
        return query.getResultList();
    }
}
