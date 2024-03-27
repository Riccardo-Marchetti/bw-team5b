package team5.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import team5.entities.DistributoreAutomatico;
import team5.entities.Rivenditore;

import java.util.List;

public class DistributoreAutomaticoDAO {
    private final EntityManager em;

    public DistributoreAutomaticoDAO(EntityManager em) {
        this.em = em;
    }

    public void salvaDistributore(DistributoreAutomatico distributoreAutomatico){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(distributoreAutomatico);

        transaction.commit();
        System.out.println("DistributoreAutomatico: " + distributoreAutomatico + " salvato correttamente");
    }

    public List<DistributoreAutomatico> getAllDistributori (){
        TypedQuery<DistributoreAutomatico> query = em.createQuery("SELECT d FROM DistributoreAutomatico d",DistributoreAutomatico.class );
        return query.getResultList();

    }

}
