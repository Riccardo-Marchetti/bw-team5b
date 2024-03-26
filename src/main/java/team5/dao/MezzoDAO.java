package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import team5.entities.Mezzo;
import team5.exception.NotFoundException;

public class MezzoDAO {

    private final EntityManager em;

    public MezzoDAO(EntityManager em) {
        this.em = em;
    }

    public  void save (Mezzo mezzo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(mezzo);
        transaction.commit();
        System.out.println("Mezzo salvato con successo");
    }

    public Mezzo findById(long id) {
        Mezzo mezzo = em.find(Mezzo.class, id);
        if (mezzo == null) throw new NotFoundException(id);
        return mezzo;
    }

    public void findByIdAndDelete(Mezzo mezzo){
        Mezzo found = this.findById(mezzo.getId());
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("Mezzo eliminato con successo");
    }
}
