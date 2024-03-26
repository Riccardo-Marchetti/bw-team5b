package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team5.entities.Manutenzione;
import team5.exception.NotFoundException;

import java.util.List;

public class ManutenzioneDAO {

    private EntityManager entityManager;

    public ManutenzioneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Manutenzione manutenzione) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(manutenzione);
        transaction.commit();
        System.out.println("Manutenzione salvata con successo");
    }

    public Manutenzione findById(int id) {
        Manutenzione manutenzione = entityManager.find(Manutenzione.class, id);
        if (manutenzione == null) throw new NotFoundException(Long.valueOf(id));
        return manutenzione;
    }

    public void findByIdAndDelete(Manutenzione manutenzione) {
        Manutenzione found = this.findById(manutenzione.getId());
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
        System.out.println("Manutenzione eliminata con successo");
    }
}

