package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import team5.entities.Percorso;
import team5.exception.NotFoundException;

import java.util.List;

public class PercorsoDAO {

    private final EntityManager em;

    public PercorsoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Percorso percorso) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(percorso);
        transaction.commit();
        System.out.println("Percorso salvato con successo");
    }

    public Percorso findById(int id) {
        Percorso percorso = em.find(Percorso.class, id);
        if (percorso == null) throw new NotFoundException(id);
        return percorso;
    }

    public void findByIdAndDelete(int id) {
        Percorso percorso = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(percorso);
        transaction.commit();
        System.out.println("Percorso eliminato con successo");
    }

    public Long countPercorsiByMezzoAndTratta(int mezzoId, String partenza, String capolinea) {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(p) FROM Percorso p WHERE p.mezzo.id = :mezzoId AND p.tratta.partenza = :partenza AND p.tratta.capolinea = :capolinea",
                Long.class
        );
        query.setParameter("mezzoId", mezzoId);
        query.setParameter("partenza", partenza);
        query.setParameter("capolinea", capolinea);
        return query.getSingleResult();
    }
        public List<Percorso> countPercorsiByMezzoAndTrattaAndGetEffectiveTime ( int mezzoId, String partenza, String capolinea){
            TypedQuery<Percorso> query = em.createQuery(
                    "SELECT p FROM Percorso p WHERE p.mezzo.id = :mezzoId AND p.tratta.partenza = :partenza AND p.tratta.capolinea = :capolinea GROUP BY p.id, p.tempoEffettivo",
                    Percorso.class
            );
            query.setParameter("mezzoId", mezzoId);
            query.setParameter("partenza", partenza);
            query.setParameter("capolinea", capolinea);

            return query.getResultList();

        }
    }


