
package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import team5.entities.InServizio;
import team5.exception.NotFoundException;

import java.util.List;

public class InServizioDAO {

    private EntityManager entityManager;

    public InServizioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(InServizio inServizio) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(inServizio);
        transaction.commit();
        System.out.println("InServizio salvato con successo");
    }

    public InServizio findById(long id) {
        InServizio inServizio = entityManager.find(InServizio.class, id);
        if (inServizio == null) throw new NotFoundException("id Servizio Non trovato");
        return inServizio;
    }

    public void findByIdAndDelete(InServizio inServizio) {
        InServizio found = this.findById(inServizio.getId());
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(found);
        transaction.commit();
        System.out.println("InServizio eliminato con successo");
    }
}


