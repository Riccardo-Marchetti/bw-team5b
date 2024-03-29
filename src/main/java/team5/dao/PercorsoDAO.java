package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team5.entities.Percorso;
import team5.exception.NotFoundException;

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
}

